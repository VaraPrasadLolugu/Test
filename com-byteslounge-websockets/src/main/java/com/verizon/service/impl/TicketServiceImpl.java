package com.verizon.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import com.verizon.dao.service.TicketDAOService;
import com.verizon.dao.service.impl.TicketDAOServiceImpl;
import com.verizon.service.TicketService;
import com.verizon.service.TicketServiceConstants;
import com.verizon.service.model.Issue;
import com.verizon.service.model.Technician;
import com.verizon.service.model.Ticket;

public class TicketServiceImpl implements TicketService {

	private TicketDAOService ticketDAOService;

	@Override
	public Ticket processIssue(Issue issue) {
		List<Technician> technicians = ticketDAOService.getTechnitianDetailsbyIssue(issue);
		int index = technicians.size();
		int randomValue = (int) Math.floor(Math.random() * index + 1);
		Technician randomTechnician = technicians.get(randomValue);
		Ticket ticket = new Ticket();
		ticket.setProgress(TicketServiceConstants.CREATED);
		ticket.setTechnicianId(randomTechnician.getTechnicianId());
		ticket.setTechnicianName(randomTechnician.getTechnicianName());
		ticketDAOService.createTicket(ticket);
		return ticket;
	}

	@Override
	public Boolean updateTicket(Ticket ticket) {
		return ticketDAOService.updateTicket(ticket);

	}

	@Override
	public String getTicketStatus(String ticketId) {

		return ticketDAOService.getTicketStatus(ticketId);
	}

	@PostConstruct
	public TicketDAOService instanciateDAOService() {
		if (null == ticketDAOService) {
			this.ticketDAOService = new TicketDAOServiceImpl();
		}
		return ticketDAOService;
	}
}
