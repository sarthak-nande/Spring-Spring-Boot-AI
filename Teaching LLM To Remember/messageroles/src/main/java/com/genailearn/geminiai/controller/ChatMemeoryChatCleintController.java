package com.genailearn.geminiai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/api")
public class ChatMemeoryChatCleintController {
	
	private final ChatClient chatClient;
	
	public ChatMemeoryChatCleintController(@Qualifier("chatMemoryChatClientConfig") ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	@GetMapping("/chat-memory")
	public String chatWithMemory(@RequestParam String message, @RequestHeader String username) {
		return chatClient.prompt().user(message).advisors(advisorSpec -> advisorSpec.param(CONVERSATION_ID, username) ).call().content();
	}

}
