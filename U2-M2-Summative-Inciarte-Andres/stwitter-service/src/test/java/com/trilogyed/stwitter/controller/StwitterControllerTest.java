package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StwitterController.class)
public class StwitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    PostViewModel pvm, pvm2, pvmNoId;

    Comment comment;

    @Before
    public void setUp() throws Exception {
        comment = new Comment();
        comment.setCommentId(4);
        comment.setCreateDate(LocalDate.of(2019,9,13));
        comment.setPostId(1);
        comment.setComment("comment");
        comment.setCommenterName("name");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        pvm = new PostViewModel();
        pvm.setPostId(1);
        pvm.setPost("Post");
        pvm.setComments(commentList);
        pvm.setPostDate(LocalDate.of(2019,11,11));
        pvm.setPosterName("Andres");

        pvm2 = new PostViewModel();
        pvm2.setPostId(2);
        pvm2.setPost("Post");
        pvm2.setComments(commentList);
        pvm2.setPostDate(LocalDate.of(2019,11,11));
        pvm2.setPosterName("JJ");

        pvmNoId = new PostViewModel();
        pvmNoId.setPost("Post");
        pvmNoId.setComments(commentList);
        pvmNoId.setPostDate(LocalDate.of(2019,11,11));
        pvmNoId.setPosterName("Andres");

    }

    @Test
    public void createNewPost() throws Exception {

        String inputJson = mapper.writeValueAsString(pvmNoId);

        String outputJson = mapper.writeValueAsString(pvm);

        when(serviceLayer.createPostViewModel(pvmNoId)).thenReturn(pvm);

        this.mockMvc.perform(post("/posts")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));


    }

    @Test
    public void getPostById() throws Exception {

        String outputJson = mapper.writeValueAsString(pvmNoId);

        when(serviceLayer.getPostViewModel(1)).thenReturn(pvm);

        this.mockMvc.perform(get("//posts/" + pvm.getPostId()))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getPostsByPoster() throws Exception {

        List<PostViewModel> pvmList = new ArrayList<>();
        pvmList.add(pvm);
        pvmList.add(pvm2);

        //Object to JSON in String
        when(serviceLayer.getPostsByPoster("Andres")).thenReturn(pvmList);

        List<PostViewModel> postListChecker = new ArrayList<>();
        postListChecker.add(pvm);

        String outputJson = mapper.writeValueAsString(postListChecker);

        when(serviceLayer.getPostsByPoster("Andres")).thenReturn(postListChecker);

        this.mockMvc.perform(get("/posts/user/" + pvm.getPosterName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }
}