package com.techelevator.npgeek.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JDBCSurveyResultDAO implements SurveyResultDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyResultDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
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