package com.verizon.dao.service;

import java.util.List;

import com.verizon.service.model.Issue;
import com.verizon.service.model.Technician;
import com.verizon.service.model.Ticket;

public interface TicketDAOService {
	
	public void createTicket(Ticket ticket);

	public Boolean updateTicket(Ticket ticket);

	public String getTicketStatus(String ticketId);

	public List<Technician> getTechnitianDetailsbyIssue(Issue issue);
}
