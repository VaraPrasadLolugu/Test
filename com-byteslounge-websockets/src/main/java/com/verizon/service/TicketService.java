package com.verizon.service;

import com.verizon.service.model.Issue;
import com.verizon.service.model.Ticket;



public interface TicketService {
	public Ticket processIssue(Issue issue);
	public Boolean updateTicket(Ticket ticket);
	public String getTicketStatus(String ticketId);

}
