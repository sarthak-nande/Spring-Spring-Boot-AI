package com.mcp.mcpserver.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcp.mcpserver.entity.HelpDeskTicket;


@Repository
public interface HelpDeskTicketRepository extends MongoRepository<HelpDeskTicket, String>{
	
	List<HelpDeskTicket> findByUsername(String username);

}
