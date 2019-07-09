package com.techelevator.npgeek.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCWeatherDAO {

	
	
	private Weather mapRowSetToWeather(SqlRowSet results) {
		Weather aWeather = new Weather();
		aWeather.setParkCode(results.getString("parkCode"));
		aWeather.setFiveDateForecastValue(results.getInt("fiveDateForecastValue"));
		aWeather.setLow(results.getInt("low"));
		aWeather.setHigh(results.getInt("high"));
		aWeather.setForecast(results.getString("forecast"));
		return aWeather;
	}		
	
}
