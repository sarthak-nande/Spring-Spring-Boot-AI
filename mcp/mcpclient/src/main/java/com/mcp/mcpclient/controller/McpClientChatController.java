package com.mcp.mcpclient.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class McpClientChatController {
	
	private final ChatClient chatClient;
	
	public McpClientChatController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	@GetMapping("/chat")
	public String chat(@RequestParam String message, @RequestHeader String username) {
		return chatClient.prompt().user(message + "and username is " + username).call().content();
	}

}
