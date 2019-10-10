package com.trilogyed.comment.controller;

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

import java.time.LocalDate;

import static org.mockito.Mockito.when;
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

    Comment comment, comment2;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(6);
        comment.setCreateDate(LocalDate.of(2019,10,11));
        comment.setCommenterName("Andres");
        comment.setComment("this post is bad.");

        comment2 = new Comment();
        comment2.setCommentId(2);
        comment2.setPostId(7);
        comment2.setCreateDate(LocalDate.of(2019,10,15));
        comment2.setCommenterName("Jay");
        comment2.setComment("this post is good.");
    }

    @Test
    public void postCommentShouldReturnAComment() throws Exception{

        commentDao.createComment(comment);

        String inputJson = mapper.writeValueAsString(comment);

        Comment outputComment = comment;

        String outputJson = mapper.writeValueAsString(outputComment);

        when(commentDao.createComment(comment)).thenReturn(outputComment);

        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }
}
