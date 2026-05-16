package com.ragimplementation.implementrag.config;

import java.util.List;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.stereotype.Service;

@Service
public class StoringDataIntoMongoDB implements ChatMemory{

	@Override
	public void add(String conversationId, List<Message> messages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> get(String conversationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear(String conversationId) {
		// TODO Auto-generated method stub
		
	}

}
