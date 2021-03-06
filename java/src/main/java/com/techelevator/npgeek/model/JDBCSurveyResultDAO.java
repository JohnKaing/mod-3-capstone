package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

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


	public List<FavoritePark> getFavoriteParks() {
		List<FavoritePark> allFavoriteParks = new ArrayList<>();
		String sqlSelectFavorites = "SELECT count(*) as surveyCount, park.parkcode, park.parkname "
				+ "from survey_result, park " + "where survey_result.parkcode = park.parkcode "
				+ "GROUP by park.parkcode, park.parkname " + "ORDER by surveycount DESC ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectFavorites);
		while (results.next()) {
			allFavoriteParks.add(new FavoritePark(results.getString("parkcode"), results.getInt("surveyCount"),
					results.getString("parkname")));
		}
		return allFavoriteParks;
	}

	@Override
	public void save(SurveyResult post) {
		int id = getNextId();
		String sqlInsertPost = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, id, post.getParkCode(), post.getEmailAddress(), post.getState(),
				post.getActivityLevel());
		post.setSurveyId(id);
	}

	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id = 0;
		if (results.next()) {
			id = results.getInt(1);
		}
		return id;
	}

}