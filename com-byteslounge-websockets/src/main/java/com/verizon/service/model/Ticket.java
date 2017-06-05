package com.verizon.service.model;

public class Ticket {

	private String ticketId;
	private String technicianId;
	private String technicianName;
	private String progress;

	/**
	 * @return the ticketId
	 */
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId
	 *            the ticketId to set
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the technicianId
	 */
	public String getTechnicianId() {
		return technicianId;
	}

	/**
	 * @param technicianId
	 *            the technicianId to set
	 */
	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}

	/**
	 * @return the technicianName
	 */
	public String getTechnicianName() {
		return technicianName;
	}

	/**
	 * @param technicianName
	 *            the technicianName to set
	 */
	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

}
