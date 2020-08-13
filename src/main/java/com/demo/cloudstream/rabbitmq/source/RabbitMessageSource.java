package com.demo.cloudstream.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitMessageSource {
	
	/**
	 * Below code will create Exchange/Channel with name mentioned in property file in RabbitMQ.
	 */
	@Output("appMessageChannelOutput")
	MessageChannel rabbitMessageChannel();
	
	/**
	 * Below code will create Queue with name mentioned in property file and Bind Exchange with Queue.
	 * 
	 * If we commit below this code with @Input annotation, we will get below exception-
	 * Description:
       A component required a bean named 'appMessageChannelInput' that could not be found.
      Action:
      Consider defining a bean named 'appMessageChannelInput' in your configuration.
	 */
	  @Input("appMessageChannelInput") 
	  SubscribableChannel recieveMessage();
	 
}
