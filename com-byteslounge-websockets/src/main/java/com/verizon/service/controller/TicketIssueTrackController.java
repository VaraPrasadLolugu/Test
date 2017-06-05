package com.verizon.service.controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.verizon.service.TicketService;
import com.verizon.service.impl.TicketServiceImpl;
import com.verizon.service.model.Issue;
import com.verizon.service.model.Ticket;

@Path("/issue")
public class TicketIssueTrackController {
	private TicketService ticketService;

	@POST
	@Path("/process")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response processIssue(Issue issue) {
		Ticket ticket = ticketService.processIssue(issue);
		String result = "Please refer " + ticket + " ticket for future reference";
		return Response.status(200).entity(result).build();

	}

	@PostConstruct
	private TicketService processTicketservice() {
		if (null == ticketService) {
			this.ticketService = new TicketServiceImpl();

		}
		return ticketService;
	}

}
