package com.demo.cloudstream.rabbitmq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cloudstream.rabbitmq.model.MessagePayload;
import com.demo.cloudstream.rabbitmq.service.MessageService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/rabbitwithstream")
public class MessageController {
	
	private MessageService messageService;
	
	@PostMapping("/sendMessage")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MessagePayload> sendMessage(@RequestBody MessagePayload messagePayload)
	{
		messageService.sentMessageToQueue(messagePayload);
		return new ResponseEntity<MessagePayload>(messagePayload, HttpStatus.CREATED);
	}

}
