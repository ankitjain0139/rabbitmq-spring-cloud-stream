package com.demo.cloudstream.rabbitmq.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

import com.demo.cloudstream.rabbitmq.model.MessagePayload;
import com.demo.cloudstream.rabbitmq.source.RabbitMessageSource;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
@EnableBinding(RabbitMessageSource.class)
public class MessageListener {
	
	@StreamListener(target = "appMessageChannelInput")
	public void recieveMessage(MessagePayload messagePayload)
	{
		System.out.println("Message listened by Listener..");
		log.info("Queue message recieved. Processed Message {}", messagePayload.getMessageId());
	}
}
