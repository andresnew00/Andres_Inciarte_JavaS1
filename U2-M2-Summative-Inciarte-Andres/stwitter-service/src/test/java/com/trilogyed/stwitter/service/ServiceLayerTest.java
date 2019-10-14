package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    @Mock
    PostFeignClient postFeignClient;
    @Mock
    CommentFeignClient commentFeignClient;
    @Mock
    RabbitTemplate rabbitTemplate;
    @InjectMocks
    ServiceLayer service;

    @Before
    public void setUp() throws Exception {
        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Andres");
        pvm.setPostDate(LocalDate.of(2019, 11, 11));
        pvm.setPost("outputPost");

        List<Comment> commentList = new ArrayList<>();
        Comment inputComment = new Comment();
        inputComment.setComment("comment");
        inputComment.setCommenterName("Name");
        inputComment.setCreateDate(LocalDate.of(2019, 12, 12));
        commentList.add(inputComment);
        pvm.setComments(commentList);

        List<Comment> commentListOne = new ArrayList<>();
        Comment outputComment = new Comment();
        outputComment.setComment("comment");
        outputComment.setCommentId(1);
        outputComment.setPostId(1);
        outputComment.setCreateDate(LocalDate.of(2019, 10, 20));
        outputComment.setCommenterName("Name");
        commentListOne.add(outputComment);

        //input sent to post service using post service client
        Post inputPost = new Post();
        inputPost.setPost(pvm.getPost());
        inputPost.setPostDate(pvm.getPostDate());
        inputPost.setPosterName(pvm.getPosterName());

        //output recieved from post service
        List<Post> postListOne = new ArrayList<>();
        Post outputPost = new Post();
        outputPost.setPostId(1);
        outputPost.setPost(pvm.getPost());
        outputPost.setPostDate(pvm.getPostDate());
        outputPost.setPosterName(pvm.getPosterName());
        postListOne.add(outputPost);

        doReturn(outputPost).when(postFeignClient).createPost(inputPost);
        doReturn(outputPost).when(postFeignClient).getPost(1);
        doReturn(commentListOne).when(commentFeignClient).findCommentsByPostId(1);
        doReturn(postListOne).when(postFeignClient).getPostsByPoster("Andres");


        inputComment.setPostId(1);


        doNothing().when(rabbitTemplate).convertAndSend(ServiceLayer.EXCHANGE, ServiceLayer.ROUTING_KEY, inputComment);

    }

    @Test
    public void CreatePostViewModel() {

        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Andres");
        pvm.setPostDate(LocalDate.of(2019, 11, 11));
        pvm.setPost("outputPost");

        List<Comment> commentList = new ArrayList<>();
        Comment inputComment = new Comment();
        inputComment.setComment("comment");
        inputComment.setCommenterName("Name");
        inputComment.setCreateDate(LocalDate.of(2019, 12, 12));
        commentList.add(inputComment);
        pvm.setComments(commentList);

        PostViewModel actualPvm = service.createPostViewModel(pvm);
        pvm.setPostId(1);
        pvm.getComments().get(0).setPostId(1);
        assertEquals(pvm, actualPvm);
        verify(rabbitTemplate, times(1)).convertAndSend(ServiceLayer.EXCHANGE, ServiceLayer.ROUTING_KEY, inputComment);
    }

    @Test
    public void getPostViewModel(){
        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Andres");
        pvm.setPostDate(LocalDate.of(2019, 11, 11));
        pvm.setPost("outputPost");

        List<Comment> commentList = new ArrayList<>();
        Comment inputComment = new Comment();
        inputComment.setComment("comment");
        inputComment.setCommenterName("Name");
        inputComment.setCreateDate(LocalDate.of(2019, 12, 12));
        commentList.add(inputComment);
        pvm.setComments(commentList);

        List<Comment> commentListOne = new ArrayList<>();
        Comment outputComment = new Comment();
        outputComment.setComment("comment");
        outputComment.setCommentId(1);
        outputComment.setPostId(1);
        outputComment.setCreateDate(LocalDate.of(2019, 10, 20));
        outputComment.setCommenterName("Name");
        commentListOne.add(outputComment);

        pvm.setPostId(1);
        pvm.getComments().get(0).setPostId(1);
        pvm.getComments().get(0).setCommentId(1);
        PostViewModel actualpvm = service.getPostViewModel(pvm.getPostId());
        assertEquals(pvm, actualpvm);
    }

    @Test
    public void getPostsByPoster(){
        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Andres");
        pvm.setPostDate(LocalDate.of(2019, 11, 11));
        pvm.setPost("outputPost");

        List<Comment> commentList = new ArrayList<>();
        Comment inputComment = new Comment();
        inputComment.setComment("comment");
        inputComment.setCommenterName("Name");
        inputComment.setCreateDate(LocalDate.of(2019, 12, 12));
        commentList.add(inputComment);
        pvm.setComments(commentList);

        List<Comment> commentListOne = new ArrayList<>();
        Comment outputComment = new Comment();
        outputComment.setComment("comment");
        outputComment.setCommentId(1);
        outputComment.setPostId(1);
        outputComment.setCreateDate(LocalDate.of(2019, 10, 20));
        outputComment.setCommenterName("Name");
        commentListOne.add(outputComment);

        pvm.setPostId(1);
        pvm.getComments().get(0).setPostId(1);
        pvm.getComments().get(0).setCommentId(1);
        List<PostViewModel> expectedPvms = new ArrayList<>();
        expectedPvms.add(pvm);
        List<PostViewModel> actualPvms = service.getPostsByPoster("Andres");
        assertEquals(expectedPvms, actualPvms);
    }

}