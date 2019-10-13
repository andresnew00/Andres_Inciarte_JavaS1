package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    @Autowired
    private final PostFeignClient postFeignClient;

    @Autowired
    private final CommentFeignClient commentFeignClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "comment-exchange";
    private static final String ROUTING_KEY = "comment.create.new";

    @Autowired
    public ServiceLayer(PostFeignClient postFeignClient, CommentFeignClient commentFeignClient, RabbitTemplate rabbitTemplate) {
        this.postFeignClient = postFeignClient;
        this.commentFeignClient = commentFeignClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    public PostViewModel createPostViewModel(PostViewModel pvm) {
        Post post = new Post();
        post.setPostDate(LocalDate.now());
        post.setPosterName(pvm.getPosterName());
        post.setPost(pvm.getPost());

        post = postFeignClient.createPost(post);

        List<Comment> commentList = pvm.getComments();
        if (!commentList.isEmpty()) {

            int p_id = post.getPostId();

            commentList.stream()
                    .forEach(comm -> comm.setCreateDate(LocalDate.now()));
            commentList.stream()
                    .forEach(comm -> comm.setPostId(p_id));

            //Queue consumer should be called here!
            sendToQueu(commentList);
        }

        pvm.setComments(commentList);
        pvm.setPostId(post.getPostId());
        pvm.setPostDate(LocalDate.now());

        return pvm;
    }

    private void sendToQueu(List<Comment> msg) {
        System.out.println("Sending message...");

        msg.stream()
                .forEach(comm ->
                        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comm));

        System.out.println("Message Sent");
    }


    public PostViewModel getPostViewModel(int id) {
        Post post = postFeignClient.getPost(id);
        return buildPostViewModel(post);
    }

    public List<PostViewModel> getPostsByPoster(String name) {
        List<Post> postList = postFeignClient.getPostsByPoster(name);

        List<PostViewModel> pvmList = new ArrayList<>();

        postList.stream()
                .forEach(post -> pvmList.add(buildPostViewModel(post)));

        return pvmList;
    }

    private PostViewModel buildPostViewModel(Post post) {
        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(post.getPostId());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setPost(post.getPost());
        pvm.setComments(commentFeignClient.findCommentsByPostId(post.getPostId()));

        return pvm;
    }

}
