package com.trilogyed.commentconsumer;

import com.trilogyed.commentconsumer.message.Comment;
import com.trilogyed.commentconsumer.util.feign.CommentFeignClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//this annotation let spring know to pay attention to this component
@Service
public class MessageListener {

    @Autowired
    CommentFeignClient commentFeignClient;

    // specifies the queues this component will listen to
    @RabbitListener(queues = CommentConsumerApplication.QUEUE_NAME)
    // receiveMessage method processes messages, takes in a comment
    //and uses the message to create a new entry
    public void receiveMessage(Comment msg) {

        System.out.println("Message received.");

        commentFeignClient.createComment(msg);

        System.out.println(msg.toString() + " message sent.");
    }

}
