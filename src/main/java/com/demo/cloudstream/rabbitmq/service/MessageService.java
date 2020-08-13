package com.demo.cloudstream.rabbitmq.service;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.demo.cloudstream.rabbitmq.model.MessagePayload;
import com.demo.cloudstream.rabbitmq.source.RabbitMessageSource;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageService {
	
	private RabbitMessageSource rabbitMessageSource;
	
	public void sentMessageToQueue(MessagePayload messagePayload) 
	{
		rabbitMessageSource.rabbitMessageChannel().send(MessageBuilder.withPayload(messagePayload).build());
		System.out.println("message sent to queue..");
	}
}
