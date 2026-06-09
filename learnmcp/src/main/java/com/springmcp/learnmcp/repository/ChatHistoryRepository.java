package com.springmcp.learnmcp.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.ai.chat.messages.Message;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmcp.learnmcp.entity.ChatHistoryModel;

public interface ChatHistoryRepository extends MongoRepository<ChatHistoryModel, String>{

	List<ChatHistoryModel> findTopNByConversationIdOrderByTimestampDesc(String conversationId, Pageable pageable);
    
    void deleteByConversationId(String conversationId);
}
