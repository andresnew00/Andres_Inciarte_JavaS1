package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class PostController {

    PostDao postDao;

    @Autowired
    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Post createPost(@Valid @RequestBody Post post) {

        return postDao.createPost(post);

    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Post getPost(@PathVariable int id) {

        Post post = postDao.getPost(id);

        if (post == null) {
            throw new IllegalArgumentException("Post could not be found for id " + id);
        } else
            return post;

    }

    @RequestMapping(value = "posts/poster/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Post> getPostsByPoster(@PathVariable("name") String name) {

        List<Post> postsByPoster = postDao.getPostsByPoster(name);

        if (postsByPoster.isEmpty()) {
            throw new IllegalArgumentException("No posts found for poster " + name);
        }

        return postsByPoster;

    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@Valid @RequestBody Post post, @PathVariable int id) {

        if (post.getPostId() == 0) {
            post.setPostId(id);
        } else if (post.getPostId() != id) {
            throw new IllegalArgumentException(
                    "Unable to update, endpoint id must match post id."
            );
        } else

            postDao.updatePost(post, id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {

        postDao.deletePost(id);

    }
}
