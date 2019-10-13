package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostFeignClient {

    @PostMapping(value = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post);

    @GetMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable int id);

    @GetMapping(value = "posts/poster/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostsByPoster(@PathVariable("name") String name);

}
