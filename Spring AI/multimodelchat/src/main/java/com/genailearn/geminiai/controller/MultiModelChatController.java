package com.genailearn.geminiai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MultiModelChatController {
	
	private final ChatClient googlChatClient;
	private final ChatClient openAiChatClient;
	
	public MultiModelChatController(@Qualifier("googleGeminiAiChatClient") ChatClient googlChatClient, @Qualifier("openAiChatClient") ChatClient openAiChatClient) {
		this.googlChatClient = googlChatClient;
		this.openAiChatClient = openAiChatClient;
	}
	
	
	@GetMapping("/geminiAi/chat")
	public String geminiAiChat(@RequestParam("message") String message) {
		return googlChatClient.prompt(message).call().content();
	}
	
	@GetMapping("/openAi/chat")
	public String openAiChat(@RequestParam("message") String message) {
		return openAiChatClient.prompt(message).call().content();
	}

}
