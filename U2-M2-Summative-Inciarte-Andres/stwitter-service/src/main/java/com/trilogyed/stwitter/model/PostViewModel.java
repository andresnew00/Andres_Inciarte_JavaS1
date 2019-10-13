package com.trilogyed.stwitter.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {

    private int postId;
    private LocalDate postDate;
    @NotEmpty(message = "Poster Name must not be empty.")
    private String posterName;
    @NotEmpty(message = "Your post is empty, cannot create an empty post.")
    private String post;
    private List<Comment> comments;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return postId == that.postId &&
                Objects.equals(postDate, that.postDate) &&
                Objects.equals(posterName, that.posterName) &&
                Objects.equals(post, that.post) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, posterName, post, comments);
    }

    @Override
    public String toString() {
        return "PostViewModel{" +
                "postId=" + postId +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                ", comments=" + comments +
                '}';
    }
}
