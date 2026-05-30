package com.springmcp.learnmcp.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultChatClientConfiguration {
	
	private final ChatMemoeryConfig chatMemoeryConfig;
	
	@Autowired
	public DefaultChatClientConfiguration(ChatMemoeryConfig chatMemoeryConfig) {
		this.chatMemoeryConfig = chatMemoeryConfig;
	}
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClient, ChatMemory chatMemory) {
		MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemoeryConfig).build();
		return chatClient
				.defaultAdvisors(messageChatMemoryAdvisor)
				.build();
	}

}
