package com.springmcp.learnmcp.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Value;

import com.springmcp.learnmcp.tools.HelpDeskTicketTool;
import com.springmcp.learnmcp.tools.TimeTool;

@Configuration
public class DefaultChatClientConfiguration {
	
	private final ChatMemoeryConfig chatMemoeryConfig;
	
	@Value("classpath:/promptTemplate/helpDeskPromptTemplate.st")
	Resource systemPromtTemplate;
	
	@Autowired
	public DefaultChatClientConfiguration(ChatMemoeryConfig chatMemoeryConfig) {
		this.chatMemoeryConfig = chatMemoeryConfig;
	}
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClient, ChatMemory chatMemory, TimeTool timeTool, HelpDeskTicketTool helpDeskTicketTool) {
		MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemoeryConfig).build();
		return chatClient
				.defaultSystem(systemPromtTemplate)
				.defaultTools(timeTool,helpDeskTicketTool)
				.defaultAdvisors(messageChatMemoryAdvisor)
				.build();
	}

}
