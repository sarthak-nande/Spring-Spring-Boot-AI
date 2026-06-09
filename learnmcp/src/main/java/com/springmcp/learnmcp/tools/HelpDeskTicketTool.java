package com.springmcp.learnmcp.tools;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import com.springmcp.learnmcp.entity.HelpDeskTicket;
import com.springmcp.learnmcp.service.HelpDeskTicketService;

@Component
public class HelpDeskTicketTool {
	
	private final Logger logger = LoggerFactory.getLogger(HelpDeskTicketTool.class);
	
	private final HelpDeskTicketService helpDeskTicketService;
	
	public HelpDeskTicketTool(HelpDeskTicketService helpDeskTicketService) {
		this.helpDeskTicketService = helpDeskTicketService;
	}

	@Tool(name="createHelpDeskTicket" , description = "Create the support ticket")
	public String createTicket(@ToolParam(description = "Details to create support tickets") ToolContext toolContext, String issue) {
		String username = toolContext.getContext().get("username").toString();
		logger.info("User ticket rquest processding.....");
		HelpDeskTicket helpDeskTicket = helpDeskTicketService.createHelpDeshTicket(issue, username);
		logger.info("User ticket is created......");
		return "Ticket created with id #" + helpDeskTicket.getId() + " for user " + helpDeskTicket.getUsername();
	}
	
	@Tool(name = "getTicketsByUsername" , description = "Fetch the status of ticket based on a given username")
	public List<HelpDeskTicket> getTicketsByUsername(ToolContext toolContext){
		String username = (String) toolContext.getContext().get("username");
		logger.info("Fetching user tickets.....");
		return helpDeskTicketService.getTicketsByUsername(username);
	}
}
