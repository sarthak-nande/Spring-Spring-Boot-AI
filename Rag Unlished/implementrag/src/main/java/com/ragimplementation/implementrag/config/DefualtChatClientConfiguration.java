package com.ragimplementation.implementrag.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefualtChatClientConfiguration {

	private final StoringDataIntoMongoDB storingDataIntoMongoDB;

	public DefualtChatClientConfiguration(StoringDataIntoMongoDB storingDataIntoMongoDB) {
		this.storingDataIntoMongoDB = storingDataIntoMongoDB;
	}

	@Bean
	public ChatClient chatClient(ChatClient.Builder chaBuilder) {
		Advisor chatMemoryAdvisor = MessageChatMemoryAdvisor.builder(storingDataIntoMongoDB).build();

		return chaBuilder
				// .defaultOptions(OllamaChatOptions.builder().model("llama3:latest").build())
				.defaultAdvisors(chatMemoryAdvisor).build();
	}

	
	//You can use this to reduce configuration related to vector store
	//@Bean
	public RetrievalAugmentationAdvisor retrievalAugmentationAdvisor(VectorStore vectorStore) {
		return RetrievalAugmentationAdvisor
				.builder()
				.documentRetriever(VectorStoreDocumentRetriever
						.builder()
						.vectorStore(vectorStore)
						.topK(3)
						.similarityThreshold(0.5)
						.build()
						).build();
	}
}
