package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {

    public Comment createComment(Comment comment);

    public Comment getComment(int id);

    public List<Comment> getAllComments();

    public List<Comment> getCommentsByPostId(int id);

    public void updateComment(Comment comment, int id);

    public void deleteComment(int id);

}
