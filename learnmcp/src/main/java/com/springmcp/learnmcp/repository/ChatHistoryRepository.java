package com.springmcp.learnmcp.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmcp.learnmcp.entity.ChatHistoryModel;

public interface ChatHistoryRepository extends MongoRepository<ChatHistoryModel, String>{

	List<ChatHistoryModel> findTop10ByConversationIdOrderByTimestampAsc(String conversationId);
    
    void deleteByConversationId(String conversationId);
}
