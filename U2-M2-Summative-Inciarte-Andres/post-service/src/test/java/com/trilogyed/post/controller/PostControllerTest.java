package com.trilogyed.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostDao postDao;

    private ObjectMapper mapper = new ObjectMapper();

    Post inputPost, outputPost, post2;

    @Before
    public void setUp() throws Exception {
        inputPost = new Post();
        inputPost.setPostDate(LocalDate.of(2019,10,10));
        inputPost.setPosterName("Andres");
        inputPost.setPost("This is a post");

        outputPost = new Post();
        outputPost.setPostId(1);
        outputPost.setPostDate(LocalDate.of(2019,10,10));
        outputPost.setPosterName("Andres");
        outputPost.setPost("This is a post");

        post2 = new Post();
        post2.setPostId(2);
        post2.setPostDate(LocalDate.of(2019,11,10));
        post2.setPosterName("Andres");
        post2.setPost("This is a another post");
    }

    @Test
    public void createPost() throws Exception{

        String inputJson = mapper.writeValueAsString(inputPost);

        String outputJson = mapper.writeValueAsString(outputPost);

        when(postDao.createPost(inputPost)).thenReturn(outputPost);

        this.mockMvc.perform(post("/posts")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPostbyId() throws Exception{

        String outputJson = mapper.writeValueAsString(outputPost);

        when(postDao.getPost(1)).thenReturn(outputPost);

        this.mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getPostsByPoster() throws Exception {

        List<Post> postList = new ArrayList<>();
        postList.add(outputPost);
        postList.add(post2);

        when(postDao.getAllPosts()).thenReturn(postList);

        List<Post> postListChecker = new ArrayList<>();
        postListChecker.addAll(postList);

        String outputJson = mapper.writeValueAsString(postListChecker);

        when(postDao.getPostsByPoster("Andres")).thenReturn(postListChecker);

        this.mockMvc.perform(get("posts/poster/Andres"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void updatePost() throws Exception {
        String inputJson = mapper.writeValueAsString(outputPost);

        this.mockMvc.perform(put("/posts/" + outputPost.getPostId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void deletePost() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/posts/1"))
                .andDo(print()).andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }
}