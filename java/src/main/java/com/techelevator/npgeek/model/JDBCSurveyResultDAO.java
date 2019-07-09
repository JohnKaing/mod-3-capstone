package com.techelevator.npgeek.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSurveyResultDAO {

	
	private SurveyResult mapRowSetToSurveyResult(SqlRowSet results) {
		SurveyResult aSurveyResult = new SurveyResult();
		aSurveyResult.setSurveyId(results.getInt("surveyId"));
		aSurveyResult.setParkCode(results.getString("parkCode"));
		aSurveyResult.setEmailAddress(results.getString("emailAddress"));
		aSurveyResult.setState(results.getString("state"));
		aSurveyResult.setActivityLevel(results.getString("activityLevel"));
		return aSurveyResult;
	}

}