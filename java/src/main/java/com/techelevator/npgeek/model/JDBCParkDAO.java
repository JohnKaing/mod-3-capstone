package com.techelevator.npgeek.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO {

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

	
	
}
