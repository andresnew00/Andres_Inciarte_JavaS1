package com.trilogyed.commentconsumer;

import com.trilogyed.commentconsumer.message.Comment;
import com.trilogyed.commentconsumer.util.feign.CommentFeignClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentFeignClient commentFeignClient;

    @RabbitListener(queues = CommentConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment msg) {

        System.out.println("Message received.");

        Comment comment = commentFeignClient.createComment(msg);

        System.out.println(msg.toString() + " message sent.");
    }

}
