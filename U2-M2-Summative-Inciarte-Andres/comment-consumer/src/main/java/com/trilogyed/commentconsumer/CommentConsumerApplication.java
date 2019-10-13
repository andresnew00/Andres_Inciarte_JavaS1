package com.trilogyed.commentconsumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CommentConsumerApplication {

	public static final String TOPIC_EXCHANGE_NAME = "comment-exchange";
	public static final String QUEUE_NAME = "comment-queue";
	public static final String ROUTING_KEY = "comment.create.#";

	// queue, exchange, binding and Jackson2Json are all set up as Spring-managed beans

	@Bean
	// the second parameter indicate if the queue should be durable between restarts
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE_NAME);
	}

	@Bean
	//binding specifies that any message sent to our topic exchange with the routing key
	// of commennt.create.# will be routed to our queue. producer is going to use this routing key
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder
				.bind(queue)
				.to(exchange)
				.with(ROUTING_KEY);
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(CommentConsumerApplication.class, args);
	}
}
