package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
// this annotation allows us to specify the name of the cache our code will use
@CacheConfig(cacheNames = "stwitter")
public class StwitterController {

    ServiceLayer service;

    @Autowired
    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    // this specifies that the annotated method should be run and the return
    // value of the method added to the cache
    @CachePut(key = "#result.getId()")
    @PostMapping(value = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewModel createNewPost(@Valid @RequestBody PostViewModel pvm) {
        return service.createPostViewModel(pvm);
    }

    // indicates that the result of the method can be cached
    @Cacheable
    @GetMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable("id") int id) {
        return service.getPostViewModel(id);
    }

    @GetMapping(value = "/posts/user/{poster_name}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostsByPoster(@PathVariable("poster_name") String name) {
        return service.getPostsByPoster(name);
    }
}
