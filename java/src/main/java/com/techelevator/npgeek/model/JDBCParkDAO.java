package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	private Park mapRowSetToPark(SqlRowSet results) {
		Park aPark = new Park();
		aPark.setParkCode(results.getString("parkCode"));
		aPark.setParkName(results.getString("parkName"));
		aPark.setState(results.getString("state"));
		aPark.setAcreage(results.getInt("acreage"));
		aPark.setElevationInFeet(results.getInt("elevationInFeet"));
		aPark.setMilesOfTrail(results.getDouble("milesOfTrail"));
		aPark.setNumberOfCampSites(results.getInt("numberOfCampSites"));
		aPark.setClimate(results.getString("climate"));
		aPark.setYearFounded(results.getInt("yearFounded"));
		aPark.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
		aPark.setInspirationalQuote(results.getString("inspirationalQuote"));
		aPark.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));
		aPark.setParkDescription(results.getString("parkDescription"));
		aPark.setEntryFee(results.getDouble("entryFee"));
		aPark.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
		return aPark;
	}


	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParks.add(mapRowSetToPark(results));
		}
		return allParks;
	}

	
	@Override
	public Park getParkByParkCode(String parkCode) {
		Park aPark = null;
		String sqlSelectParkByParkCode = "SELECT * FROM park WHERE parkcode = ? ORDER BY parkName ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByParkCode, parkCode);
		if (results.next()) {
			aPark = mapRowSetToPark(results);
		}
		return aPark;
	}

	
	
	
	
}
