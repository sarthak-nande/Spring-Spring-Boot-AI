package com.springchatmemory.springbootchatmemory.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

	private final ChatMemoryConfig chatMemoryConfig;

	@Autowired
	public ChatClientConfig(ChatMemoryConfig chatMemoryConfig) {
		this.chatMemoryConfig = chatMemoryConfig;
	}

	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
		Advisor chatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemoryConfig).build();
		return chatClientBuilder
				.defaultOptions(OllamaChatOptions.builder().model("llama3").build())
				.defaultAdvisors(chatMemoryAdvisor)
				.build();
	}
}
