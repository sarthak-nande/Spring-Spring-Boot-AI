package com.mcp.mcpserver.tool;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcp.mcpserver.entity.HelpDeskTicket;
import com.mcp.mcpserver.services.HelpDeskTicketService;

@Component
public class HelpDeskTicketTool {

	private final Logger logger = LoggerFactory.getLogger(HelpDeskTicketTool.class);
	
	private final HelpDeskTicketService helpDeskTicketService;
	
	@Autowired
	public HelpDeskTicketTool(HelpDeskTicketService helpDeskTicketService) {
		this.helpDeskTicketService = helpDeskTicketService;
	}
	
	@Tool(name="createHelpDeskTicket" , description = "Crate Help Desk Support Issue")
	public String createHelpDeskTicket(@ToolParam(description = "Required Details To Create Support Ticket") String issue , String username) {
		logger.info("Starting Creating Ticket....");
		HelpDeskTicket helpDeskTicket = helpDeskTicketService.createHelpDeshTicket(issue, username);
		logger.info("Help Desk Support Ticket Created!");
		return "Help Desk Ticket " + helpDeskTicket.getId() + "created for user " + helpDeskTicket.getUsername(); 
	}
	
	@Tool(name="getHelpDeskTicktStatus", description="Provide the status of help desk ticket/tickets based on username")
	public List<HelpDeskTicket> getHelpDeskTicketStatus(String username){
		logger.info("Fetching Help Desk Tickets...");
		List<HelpDeskTicket> helpDeskTickets = helpDeskTicketService.getTicketsByUsername(username);
		logger.info("Fetched Help Desk Tickets....");
		return helpDeskTickets;
	}
	
}
