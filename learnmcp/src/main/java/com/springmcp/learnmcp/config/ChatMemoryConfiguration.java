package com.springmcp.learnmcp.config;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.mongo.MongoChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ChatMemoryConfiguration {

	@Bean
	public ChatMemory chatMemory(MongoTemplate mongoTemplate) {
		MongoChatMemoryRepository mongoChatMemoryRepository = MongoChatMemoryRepository.builder()
				.mongoTemplate(mongoTemplate)
				.build();
		
		return MessageWindowChatMemory.builder()
				.chatMemoryRepository(mongoChatMemoryRepository)
				.maxMessages(10)
				.build();
	}
}
