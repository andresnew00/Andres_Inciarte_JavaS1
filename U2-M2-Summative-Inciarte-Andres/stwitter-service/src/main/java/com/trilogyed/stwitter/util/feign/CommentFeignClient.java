package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentFeignClient {

    @GetMapping(value = "/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment findComment(@PathVariable("id") int id);

    @GetMapping(value = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findAllComments();

    @GetMapping(value = "/comments/postid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findCommentsByPostId(@PathVariable("id") int id);

    @PutMapping(value = ("/comment/{id}"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@Valid @RequestBody Comment comment, @PathVariable("id") int id);

    @DeleteMapping(value = "/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id);

}
