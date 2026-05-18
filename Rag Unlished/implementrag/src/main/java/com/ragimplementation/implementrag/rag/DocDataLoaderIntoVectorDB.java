package com.ragimplementation.implementrag.rag;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DocDataLoaderIntoVectorDB {

	private final VectorStore vectorStore;
	
	@Value("classpath:Eazybytes_HR_Policies.pdf")
	Resource hrPolicyPDF;
	
	@Autowired
	public DocDataLoaderIntoVectorDB(VectorStore vectorStore) {
		this.vectorStore = vectorStore;
	}
	
	@PostConstruct
	public void loadPDFData() {
		TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(hrPolicyPDF);
		List<Document> data = tikaDocumentReader.get();
		TextSplitter textSplitter = TokenTextSplitter.builder().withChunkSize(100).withMaxNumChunks(400).build();
		vectorStore.add(textSplitter.split(data));
	}
	
}
