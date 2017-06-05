package com.verizon.service.model;

import java.util.List;

/**
 * @author prasad
 *
 */
public class Issue {

	public String customerId;
	public String issueType;
	public String complaint;
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the issueType
	 */
	public String getIssueType() {
		return issueType;
	}
	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	/**
	 * @return the complaint
	 */
	public String getComplaint() {
		return complaint;
	}
	/**
	 * @param complaint the complaint to set
	 */
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

}
