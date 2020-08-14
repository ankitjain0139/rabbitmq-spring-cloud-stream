package com.demo.cloudstream.rabbitmq.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.cloudstream.rabbitmq.model.MessagePayload;
import com.demo.cloudstream.rabbitmq.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
class MessageControllerTest {

	//@InjectMocks
	private MessageController messageController;

	@Mock
	private MessageService messageService;

	private MockMvc mockMvc;
	private MessagePayload messagePayload;
	private EasyRandomParameters parameters;
	private EasyRandom easyRandomGenerators;
	private static ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		//MockitoAnnotations.initMocks(this);
		messageController = new MessageController(messageService);
		mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();

		parameters = new EasyRandomParameters();
		// or parameters = new EasyRandomParameters().randomize(String.class, () ->
		// "test");

		easyRandomGenerators = new EasyRandom(parameters);
		messagePayload = easyRandomGenerators.nextObject(MessagePayload.class);
		/**
		 * to generate a list messagePayloadList =
		 * easyRandomGenerator.objects(MessagePayload.class,
		 * 1).collect(Collectors.toList());
		 */

	}

	@Test
	void testSendMessage() throws Exception {
		doNothing().when(messageService).sentMessageToQueue(messagePayload);

		String postBody = mapper.writeValueAsString(messagePayload);
		mockMvc.perform(
				post("/v1/rabbitwithstream/sendMessage").content(postBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		verify(messageService, times(1)).sentMessageToQueue(messagePayload);
	}

}
