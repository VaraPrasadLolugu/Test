package com.verizon.dao.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.verizon.dao.service.TicketDAOService;
import com.verizon.dao.service.TicketDataSource;
import com.verizon.service.model.Issue;
import com.verizon.service.model.Technician;
import com.verizon.service.model.Ticket;

public class TicketDAOServiceImpl implements TicketDAOService {

	private DataSource dataSource;

	@Override
	public void createTicket(Ticket ticket) {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO ticket ( TechnicianId,Progress) VALUES ( ?,?)");
			preparedStatement.setString(1, ticket.getTechnicianId());
			preparedStatement.setString(2, ticket.getProgress());
			preparedStatement.execute();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public Boolean updateTicket(Ticket ticket) {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement preparedStatement;

			preparedStatement = con
					.prepareStatement("UPDATE ticket SET Progress=? and TechnicianId=? where TicketId=?");
			preparedStatement.setString(1, ticket.getProgress());
			preparedStatement.setString(2, ticket.getTechnicianId());
			preparedStatement.setString(3, ticket.getTicketId());
			int result = preparedStatement.executeUpdate();
			con.close();
			return 0 == result ? false : true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getTicketStatus(String ticketId) {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement("Select Progress from ticket where ticketId=?");
			preparedStatement.setString(1, ticketId);
			ResultSet rs = preparedStatement.executeQuery();
			con.close();
			return rs.getString("Progress");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Technician> getTechnitianDetailsbyIssue(Issue issue) {
		List<Technician> technicians = new ArrayList<>();
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement("Select * from Technician where issueType=?");
			preparedStatement.setString(1, issue.getIssueType());
			ResultSet rs = preparedStatement.executeQuery();
			con.close();
			while (rs.next()) {
				Technician technician = new Technician();
				technician.setTechnicianId(rs.getString(1));
				technician.setTechnicianName(rs.getString(2));
				technician.setIssueType(rs.getString(3));
				technicians.add(technician);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return technicians;
	}

	@PostConstruct
	private void processDataSource() {
		if (null == dataSource) {
			this.dataSource = TicketDataSource.getDataSource();
		}

	}

}
