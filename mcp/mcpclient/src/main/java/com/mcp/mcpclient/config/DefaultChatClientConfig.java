package com.mcp.mcpclient.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultChatClientConfig {
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClient, ToolCallbackProvider toolCallbackProvider) {
		return chatClient.defaultToolCallbacks(toolCallbackProvider).defaultAdvisors(new SimpleLoggerAdvisor()).build();
	}

}
