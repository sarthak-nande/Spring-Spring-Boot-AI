package com.springchatmemory.springbootchatmemory.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

	private final ChatMemoryConfig chatMemoryConfig;

	public ChatClientConfig(ChatMemoryConfig chatMemoryConfig) {
		this.chatMemoryConfig = chatMemoryConfig;
	}

	public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
		Advisor chatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemoryConfig).build();
		return chatClientBuilder
				.defaultOptions(OllamaChatOptions.builder().model("llama3").build())
				.defaultAdvisors(chatMemoryAdvisor)
				.build();
	}
}
