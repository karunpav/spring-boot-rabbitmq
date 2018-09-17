package com.rabbitmq.simple_example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.simple_example.assets.Order;

@Configuration
public class RabbitMqConfig {
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		Jackson2JsonMessageConverter jsonMessageConverter  = new Jackson2JsonMessageConverter();
		jsonMessageConverter.setClassMapper(classMapper());
		return jsonMessageConverter;
	}
	
	// Converts POJOs to JSON
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(jsonMessageConverter());
		return template;
	}
	
	// Converting from JSON to the Order class
	@Bean
	public DefaultClassMapper classMapper() {
		DefaultClassMapper classMapper = new DefaultClassMapper();
		Map<String, Class<?>> idClassMapping = new HashMap<>();
		idClassMapping.put("com.rabbitmq.simple_example.assets.Order", Order.class);
		classMapper.setIdClassMapping(idClassMapping);
		return classMapper;
	}
}
