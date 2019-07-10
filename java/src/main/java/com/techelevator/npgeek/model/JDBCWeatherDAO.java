package com.techelevator.npgeek.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JDBCWeatherDAO implements WeatherDAO {
		
		private JdbcTemplate jdbcTemplate;

		@Autowired
		public JDBCWeatherDAO(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

	
	
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
