package com.techelevator.npgeek.model;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SurveyResult {

	private int surveyId;
	private String parkCode;
	@NotBlank(message = "Email required please try again")
	@Email(message = "Invalid email format, please try again.")
	private String emailAddress;
	private String state;
	private String activityLevel;
	private int surveyCount;

	/**
	 * @return the surveyId
	 */
	public int getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the parkCode
	 */
	public String getParkCode() {
		return parkCode;
	}

	/**
	 * @param parkCode the parkCode to set
	 */
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the activityLevel
	 */
	public String getActivityLevel() {
		return activityLevel;
	}

	/**
	 * @param activityLevel the activityLevel to set
	 */
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public void setDatePosted(LocalDateTime now) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the surveyCount
	 */
	public int getSurveyCount() {
		return surveyCount;
	}

	/**
	 * @param surveyCount the surveyCount to set
	 */
	public void setSurveyCount(int surveyCount) {
		this.surveyCount = surveyCount;
	}

}
