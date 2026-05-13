package com.springchatmemory.springbootchatmemory.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;
import com.springchatmemory.springbootchatmemory.config.ChatClientConfig;

@RestController
@RequestMapping("/api")
public class ChatController {
	
	private final ChatClient chatClient;
	
	public ChatController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	@GetMapping("/chat")
	public String chat(@RequestParam("message") String message, @RequestHeader String username) {
		return chatClient.prompt().advisors(advisorSpec -> advisorSpec.param(CONVERSATION_ID, username)).user(message).call().content();
	}
}
