package com.springmcp.learnmcp.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultChatClientConfiguration {
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClient, ChatMemory chatMemory) {
		MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
		return chatClient
				.defaultAdvisors(messageChatMemoryAdvisor)
				.build();
	}

}
