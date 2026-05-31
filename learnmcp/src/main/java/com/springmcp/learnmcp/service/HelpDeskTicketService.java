package com.springmcp.learnmcp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmcp.learnmcp.entity.HelpDeskTicket;
import com.springmcp.learnmcp.repository.HelpDeskTicketRepository;

@Service
public class HelpDeskTicketService {

	private final HelpDeskTicketRepository helpDeskTicketRepository;
	
	@Autowired
	public HelpDeskTicketService(HelpDeskTicketRepository helpDeskTicketRepository) {
		this.helpDeskTicketRepository = helpDeskTicketRepository;
	}
	
	public void createHelpDeshTicket(String ticketIssue, String username) {
		
		HelpDeskTicket ticket = new HelpDeskTicket(
				username,ticketIssue,"OPEN",LocalDateTime.now(),LocalDateTime.now().plusDays(70)
		);
		
		helpDeskTicketRepository.save(ticket);
				
	}
	
	public List<HelpDeskTicket> getTicketsByUsername(String username){
		return helpDeskTicketRepository.findByUsername(username);
	}
}
