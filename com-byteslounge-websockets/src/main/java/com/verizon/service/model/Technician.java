package com.verizon.service.model;

public class Technician {
	private String technicianId;
	private String technicianName;
	private String issueType;

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
	 * @return the issueType
	 */
	public String getIssueType() {
		return issueType;
	}

	/**
	 * @param issueType
	 *            the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

}
