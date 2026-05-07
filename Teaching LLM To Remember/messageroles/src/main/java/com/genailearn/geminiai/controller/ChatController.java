package com.genailearn.geminiai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ChatController {
	
	private final ChatClient chatClient;
	
	public ChatController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	@GetMapping("/chat")
	public String chat(@RequestParam("message") String message) {
		return chatClient.prompt().user(message).call().content();
	}
	
	@GetMapping("/stream")
	public Flux<String> streamChat(@RequestParam("message") String message){
		return chatClient.prompt().user(message).stream().content();
	}

}
