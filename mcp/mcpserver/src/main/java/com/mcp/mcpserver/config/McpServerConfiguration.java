package com.mcp.mcpserver.config;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcp.mcpserver.tool.HelpDeskTicketTool;

@Configuration
public class McpServerConfiguration {
	
	@Bean
	public List<ToolCallback> toolCallbacks(HelpDeskTicketTool helpDeskTicketTool){
		return List.of(ToolCallbacks.from(helpDeskTicketTool));
	}

}
