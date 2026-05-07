package com.genailearn.geminiai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatMemeoryChatCleintController {
	
	private final ChatClient chatClient;
	
	public ChatMemeoryChatCleintController(@Qualifier("chatMemoryChatClientConfig") ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	public String chatWithMemory(@RequestParam String message) {
		return chatClient.prompt().user(message).call().content();
	}

}
