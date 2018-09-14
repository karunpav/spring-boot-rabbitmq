package com.rabbitmq.simple_example.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.simple_example.assets.Order;

@Component
@RabbitListener(queues = { "orders_queue" })

// Just listens with RabbitHandler and publishes it to Logger
public class Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

	@RabbitHandler
	public void receiveMessages(Order order) {
		LOGGER.info("Order received: <" + order.toString() + ">");
	}
}
