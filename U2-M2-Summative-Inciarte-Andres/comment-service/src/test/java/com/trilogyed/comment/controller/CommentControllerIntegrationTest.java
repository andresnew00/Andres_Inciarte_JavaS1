package com.trilogyed.comment.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentDao commentDao;

    Comment comment1, comment2, comment1NoId;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

        comment1NoId = new Comment();
        comment1NoId.setPostId(6);
        comment1NoId.setCreateDate(LocalDate.of(2019, 10, 11));
        comment1NoId.setCommenterName("Andres");
        comment1NoId.setComment("this post is bad.");

        comment1 = new Comment();
        comment1.setCommentId(1);
        comment1.setPostId(6);
        comment1.setCreateDate(LocalDate.of(2019, 10, 11));
        comment1.setCommenterName("Andres");
        comment1.setComment("this post is bad.");

        comment2 = new Comment();
        comment2.setCommentId(2);
        comment2.setPostId(6);
        comment2.setCreateDate(LocalDate.of(2019, 10, 15));
        comment2.setCommenterName("Jay");
        comment2.setComment("this post is good.");

        when(commentDao.createComment(comment1NoId)).thenReturn(comment1);

    }

    @Test
    public void postCommentShouldReturnAComment() throws Exception {

        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        String inputJson = mapper.writeValueAsString(comment1NoId);

        String outputJson = mapper.writeValueAsString(comment1);

        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getCommentbyPostId() throws Exception {

        String outputJson = mapper.writeValueAsString(comment1);

        when(commentDao.getComment(1)).thenReturn(comment1);

        this.mockMvc.perform(get("/comment/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void updateComment() throws Exception {

        doNothing().when(commentDao).updateComment(comment1 , 1);

        String inputJson = mapper.writeValueAsString(comment1);

        this.mockMvc.perform(put("/comment/1")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print()).andExpect(status().isOk());
        verify(commentDao,times(1)).updateComment(comment1,1);

    }

    @Test
    public void deleteComment() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/comment/" + comment1.getCommentId()))
                .andDo(print()).andExpect(status().isNoContent())
                .andExpect(content().string(""));

    }
}
