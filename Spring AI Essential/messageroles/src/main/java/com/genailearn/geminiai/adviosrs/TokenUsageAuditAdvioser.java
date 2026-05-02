package com.genailearn.geminiai.adviosrs;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;

public class TokenUsageAuditAdvioser implements CallAdvisor{
	
	private final Logger logger = LoggerFactory.getLogger(TokenUsageAuditAdvioser.class);

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "TokenUsageAuditAdvioser";
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
		ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
		ChatResponse chatResponse = chatClientResponse.chatResponse();
		if(chatResponse.getMetadata() != null) {
			Usage usage = chatResponse.getMetadata().getUsage();
			
			if(usage != null) {
				logger.info("total usage :" + usage.toString());
			}
		}
		return chatClientResponse;
	}

}
