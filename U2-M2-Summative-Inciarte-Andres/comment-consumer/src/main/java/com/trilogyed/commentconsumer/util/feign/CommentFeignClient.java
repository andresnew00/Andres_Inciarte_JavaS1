package com.trilogyed.commentconsumer.util.feign;

import com.trilogyed.commentconsumer.message.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = "comment-service")
public interface CommentFeignClient {

    @PostMapping(value = "/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@Valid @RequestBody Comment comment);

}
