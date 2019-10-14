package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostDaoJdbcTemplateImplTest {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp() throws Exception {

        postDao.getAllPosts().forEach(post -> postDao.deletePost(post.getPostId()));

    }

    @Test
    public void createGetPost() {

        Post post = new Post();
        post.setPostDate(LocalDate.now());
        post.setPosterName("Andres Inciarte");
        post.setPost("post message");
        post = postDao.createPost(post);

        Post post2 = postDao.getPost(post.getPostId());

        assertEquals(post, post2);

    }

    @Test
    public void getPostsByPoster() {

        List<Post> posts = new ArrayList<>();

        Post post = new Post();
        post.setPostDate(LocalDate.now());
        post.setPosterName("Andres Inciarte");
        post.setPost("post message");
        post = postDao.createPost(post);
        posts.add(post);

        Post post2 = new Post();
        post2.setPostDate(LocalDate.now());
        post2.setPosterName("Andres Inciarte");
        post2.setPost("post message 2");
        post2 = postDao.createPost(post);
        posts.add(post2);

        List<Post> postsFromDao = postDao.getPostsByPoster("Andres Inciarte");

        assertEquals(posts.size(), postsFromDao.size());

        postsFromDao = postDao.getPostsByPoster("John Doe");

        assertEquals(0, postsFromDao.size());

    }

    @Test
    public void updatePost() {

        Post post = new Post();
        post.setPostDate(LocalDate.now());
        post.setPosterName("Andres Inciarte");
        post.setPost("post message");
        post = postDao.createPost(post);

        post.setPost("post message nice");

        postDao.updatePost(post, post.getPostId());

        Post post2 = postDao.getPost(post.getPostId());

        assertEquals(post, post2);

        post.setPost("post message very nice");

        postDao.updatePost(post, post.getPostId() + 1);

        post2 = postDao.getPost(post.getPostId() + 1);

        assertNull(post2);
    }

    @Test
    public void deletePost() {

        Post post = new Post();
        post.setPostDate(LocalDate.now());
        post.setPosterName("Andres Inciarte");
        post.setPost("post message");
        post = postDao.createPost(post);

        postDao.deletePost(post.getPostId());

        post = postDao.getPost(post.getPostId());

        assertNull(post);

    }
}