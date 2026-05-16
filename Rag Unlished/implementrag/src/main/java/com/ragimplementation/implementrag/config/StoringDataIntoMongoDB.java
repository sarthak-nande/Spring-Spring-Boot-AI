package com.ragimplementation.implementrag.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ragimplementation.implementrag.model.ChatHistoryModel;
import com.ragimplementation.implementrag.repository.ChatHistoryRepository;

@Service
public class StoringDataIntoMongoDB implements ChatMemory{
	
	private final ChatHistoryRepository chatHistoryRepository;
	
	@Autowired
	public StoringDataIntoMongoDB(ChatHistoryRepository chatHistoryRepository) {
		this.chatHistoryRepository = chatHistoryRepository;
	}

	@Override
	public void add(String conversationId, List<Message> messages) {
		for(Message message: messages) {
			ChatHistoryModel newChat = new ChatHistoryModel(
					conversationId,
					message.getText(),
					message.getMessageType().toString(),
					LocalDateTime.now()
			);
			
			chatHistoryRepository.save(newChat);
		}
		
		
		
	}

	@Override
	public List<Message> get(String conversationId) {
		return chatHistoryRepository
				.findTopNByConversationIdOrderByTimestampDesc(conversationId, PageRequest.of(0, 10))
				.stream()
				.map(t -> "USER".equals(t.getMessageType()) ? new UserMessage(t.getContent()) : new SystemMessage(t.getContent()))
				.collect(Collectors.toList());
				
	}

	@Override
	public void clear(String conversationId) {
		chatHistoryRepository.deleteByConversationId(conversationId);
		
	}

}
