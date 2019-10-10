package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoJdbcTemplateImpTest {

    @Autowired
    CommentDao commentDao;

    Comment comment, comment2;

    @Before
    public void setUp() throws Exception {


        commentDao.getAllComments().forEach(comment -> commentDao.deleteComment(comment.getCommentId()));

        comment = new Comment();
        comment.setPostId(6);
        comment.setCreateDate(LocalDate.of(2019,10,11));
        comment.setCommenterName("Andres");
        comment.setComment("this post is bad.");

        comment2 = new Comment();
        comment2.setPostId(7);
        comment2.setCreateDate(LocalDate.of(2019,10,15));
        comment2.setCommenterName("Jay");
        comment2.setComment("this post is good.");

    }

    @Test
    public void createComment() {

        comment = commentDao.createComment(comment);

        assertEquals(1, commentDao.getAllComments().size());

    }

    @Test
    public void getAllComments() {

        comment = commentDao.createComment(comment);
        comment2 = commentDao.createComment(comment2);

        assertEquals(2, commentDao.getAllComments().size());

    }

    @Test
    public void getCommentsByPostId() {

        comment = commentDao.createComment(comment);

        List<Comment> commentListById = commentDao.getCommentsByPostId(6);

        assertEquals(1,commentListById.size());
    }

    @Test
    public void updateComment() {

        comment.setComment("no");

        commentDao.updateComment(comment, comment.getCommentId());

        Comment actualComment = comment;

        assertEquals(comment, actualComment);

    }

    @Test
    public void deleteComment() {

        commentDao.deleteComment(6);

        comment = commentDao.getComment(6);

        assertNull(comment);

    }

}
