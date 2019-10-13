package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    PostFeignClient postFeignClient;
    CommentFeignClient commentFeignClient;
    RabbitTemplate rabbitTemplate;
    ServiceLayer service;

    @Before
    public void setUp() throws Exception {

        setUpCommentClient();
        setUpPostClient();

        service = new ServiceLayer(postFeignClient, commentFeignClient, rabbitTemplate);
    }

    @Test
    public void createPostViewModel() {
        List<Comment> commentList = new ArrayList<>();

        Comment comment2 = new Comment();
        comment2.setCommenterName("John Wick");
        comment2.setComment("Today is a great day!");
        commentList.add(comment2);

        Comment comment3 = new Comment();
        comment3.setCommenterName("Jay Edwards");
        comment3.setComment("This is my comment about this!");
        commentList.add(comment3);

        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Jeff Hardy");
        pvm.setPost("O'Doyle rules!");
        pvm.setComments(commentList);

        pvm = service.createPostViewModel(pvm);

        PostViewModel pvmFromMock = service.getPostViewModel(5);

        assertEquals(pvm, pvmFromMock);
        verify(rabbitTemplate).convertAndSend(any(String.class), any(String.class));
    }

    @Test
    public void getPostViewModel() {
        PostViewModel pvm1 = service.getPostViewModel(5);

        List<Comment> commentList = new ArrayList<>();

        Comment comment2 = new Comment();
        comment2.setCommentId(8);
        comment2.setPostId(5);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("John Wick");
        comment2.setComment("Today is a great day!");
        commentList.add(comment2);

        Comment comment3 = new Comment();
        comment3.setCommentId(9);
        comment3.setPostId(5);
        comment3.setCreateDate(LocalDate.now());
        comment3.setCommenterName("Jay Edwards");
        comment3.setComment("This is my comment about this!");
        commentList.add(comment3);

        PostViewModel pvm2 = new PostViewModel();
        pvm2.setPostId(5);
        pvm2.setPostDate(LocalDate.now());
        pvm2.setPosterName("Jeff Hardy");
        pvm2.setPost("O'Doyle rules!");
        pvm2.setComments(commentList);

        assertEquals(pvm2, pvm1);

    }

    @Test
    public void getPostsByPoster() {
        List<PostViewModel> pvmList1 = service.getPostsByPoster("Jeff Hardy");
        List<PostViewModel> pvmList2 = new ArrayList<>();

        List<Comment> commentList = new ArrayList<>();
        List<Comment> commentList2 = new ArrayList<>();

        Comment comment2 = new Comment();
        comment2.setCommentId(8);
        comment2.setPostId(5);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("John Wick");
        comment2.setComment("Today is a great day!");
        commentList.add(comment2);

        Comment comment3 = new Comment();
        comment3.setCommentId(9);
        comment3.setPostId(5);
        comment3.setCreateDate(LocalDate.now());
        comment3.setCommenterName("Jay Edwards");
        comment3.setComment("This is my comment about this!");
        commentList.add(comment3);

        PostViewModel pvm2 = new PostViewModel();
        pvm2.setPostId(5);
        pvm2.setPostDate(LocalDate.now());
        pvm2.setPosterName("Jeff Hardy");
        pvm2.setPost("O'Doyle rules!");
        pvm2.setComments(commentList);
        pvmList2.add(pvm2);

        PostViewModel pvm3 = new PostViewModel();
        pvm3.setPostId(6);
        pvm3.setPostDate(LocalDate.now());
        pvm3.setPosterName("Jeff Hardy");
        pvm3.setPost("Today was insightful.");
        pvm3.setComments(commentList2);
        pvmList2.add(pvm3);

        assertEquals(pvmList2, pvmList1);

    }

    public void setUpPostClient(){

        postFeignClient = mock(PostFeignClient.class);
        List<Post> postList = new ArrayList<>();

        Post post = new Post();
        post.setPostDate(LocalDate.now());
        post.setPosterName("Jeff Hardy");
        post.setPost("O'Doyle rules!");

        Post post1 = new Post();
        post1.setPostId(5);
        post1.setPostDate(LocalDate.now());
        post1.setPosterName("Jeff Hardy");
        post1.setPost("O'Doyle rules!");
        postList.add(post1);

        Post post2 = new Post();
        post2.setPostId(6);
        post2.setPostDate(LocalDate.now());
        post2.setPosterName("Jeff Hardy");
        post2.setPost("Today was insightful.");
        postList.add(post2);

        doReturn(post1).when(postFeignClient).createPost(post);
        doReturn(post1).when(postFeignClient).getPost(5);
        doReturn(post2).when(postFeignClient).getPost(6);
        doReturn(postList).when(postFeignClient).getPostsByPoster("Jeff Hardy");


    }

    public void setUpCommentClient(){
        commentFeignClient = mock (CommentFeignClient.class);
        List<Comment> commentList = new ArrayList<>();
        List<Comment> commentList2 = new ArrayList<>();

        Comment comment = new Comment();
        comment.setPostId(5);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("John Wick");
        comment.setComment("Today is a great day!");

        Comment comment2 = new Comment();
        comment2.setCommentId(8);
        comment2.setPostId(5);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("John Wick");
        comment2.setComment("Today is a great day!");
        commentList.add(comment2);

        Comment comment3 = new Comment();
        comment3.setCommentId(9);
        comment3.setPostId(5);
        comment3.setCreateDate(LocalDate.now());
        comment3.setCommenterName("Jay Edwards");
        comment3.setComment("This is my comment about this!");
        commentList.add(comment3);


        doReturn(comment2).when(commentFeignClient).findComment(8);
        doReturn(commentList).when(commentFeignClient).findCommentsByPostId(5);
        doReturn(commentList2).when(commentFeignClient).findCommentsByPostId(6);


    }

    public void setUpRabbitTemplate(){
        rabbitTemplate = mock (RabbitTemplate.class);

        String EXCHANGE = "comment-exchange";
        String ROUTING_KEY = "comment.create.new";

        List<Comment> commentList = new ArrayList<>();

        Comment comment2 = new Comment();

        comment2.setPostId(5);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("John Wick");
        comment2.setComment("Today is a great day!");
        commentList.add(comment2);

        Comment comment3 = new Comment();

        comment3.setPostId(5);
        comment3.setCreateDate(LocalDate.now());
        comment3.setCommenterName("Jay Edwards");
        comment3.setComment("This is my comment about this!");
        commentList.add(comment3);

        doNothing().when(rabbitTemplate).convertAndSend(EXCHANGE, ROUTING_KEY, comment2);
        doNothing().when(rabbitTemplate).convertAndSend(EXCHANGE, ROUTING_KEY, comment3);
    }

}