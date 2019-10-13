package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;

import java.util.List;

public interface PostDao {

    public Post createPost(Post post);

    public Post getPost(int id);

    public List<Post> getAllPosts();

    public List<Post> getPostsByPoster(String name);

    public void updatePost(Post post, int id);

    public void deletePost(int id);

}
