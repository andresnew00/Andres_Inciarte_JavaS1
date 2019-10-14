package com.trilogyed.comment.controller;

import com.sun.jersey.api.NotFoundException;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentDao commentDao;

    @PostMapping(value = "/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@Valid @RequestBody Comment comment) {
        comment = commentDao.createComment(comment);

        if (comment == null) {
            throw new NotFoundException("not able to return comment, better luck next time");
        }
        return comment;
    }

    @GetMapping(value = "/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment findComment(@PathVariable("id") int id) {
        Comment comment = commentDao.getComment(id);

        if (comment == null) {
            throw new NotFoundException("unable to find a comment by the id: " + id);
        }
        return comment;
    }

    @GetMapping(value = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findAllComments() {
        List<Comment> comments = commentDao.getAllComments();
        if (comments.isEmpty()) {
            throw new NotFoundException("No comments found");
        }
        return comments;
    }

    @GetMapping(value = "/comments/postid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findCommentsByPostId(@PathVariable("id") int id) {
        List<Comment> comments = commentDao.getCommentsByPostId(id);

        if (comments.isEmpty()) {
            throw new NotFoundException("No comments found for post id " + id);
        }
        return comments;
    }

    @PutMapping(value = ("/comment/{id}"))
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@Valid @RequestBody Comment comment, @PathVariable("id") int id) {
        if (comment.getCommentId() != id) {
            throw new NotFoundException("Id does not match comment id");
        }
        commentDao.updateComment(comment, id);
    }

    @DeleteMapping(value = "/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id) {
        commentDao.deleteComment(id);
    }
}
