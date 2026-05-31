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

	@Tool(name="createHelpDeskTicket" , description = "This tool will create the help desk support ticket using provided info such as issue and username")
	public String createTicket(@ToolParam(description = "this is required info to create ticket") ToolContext toolContext, String issue) {
		String username = toolContext.getContext().get("username").toString();
		HelpDeskTicket helpDeskTicket = helpDeskTicketService.createHelpDeshTicket(issue, username);
		
		return "Ticket created with id #" + helpDeskTicket.getId() + " for user " + helpDeskTicket.getUsername();
	}
	
	@Tool(name = "getTicketsByUsername" , description = "This tool will used to get all help desk tickets created by current user")
	public List<HelpDeskTicket> getTicketsByUsername(ToolContext toolContext){
		String username = (String) toolContext.getContext().get("username");
		return helpDeskTicketService.getTicketsByUsername(username);
	}
}
