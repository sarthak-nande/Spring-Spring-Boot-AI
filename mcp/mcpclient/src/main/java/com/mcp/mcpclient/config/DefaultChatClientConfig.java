package com.mcp.mcpclient.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultChatClientConfig {
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClient) {
		return chatClient.defaultAdvisors(new SimpleLoggerAdvisor()).build();
	}

}
