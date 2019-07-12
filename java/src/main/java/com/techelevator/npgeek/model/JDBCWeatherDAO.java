package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

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

	
	
	private Weather mapRowSetToWeather(SqlRowSet results, String tempUnit) {
		Weather aWeather = new Weather();
		aWeather.setParkCode(results.getString("parkCode"));
		aWeather.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
		aWeather.setLow(tempUnit.equals("C")? (results.getInt("low") - 32) * 5/9 : results.getInt("low"));
		aWeather.setHigh(tempUnit.equals("C")? (results.getInt("high") - 32) * 5/9 : results.getInt("high"));
		aWeather.setForecast(results.getString("forecast"));
		return aWeather;
	}



	@Override
	public List<Weather> getForecastByParkCode(String parkCode, String tempUnit) {
			Weather aWeather = null;
			List<Weather> parkWeather = new ArrayList<Weather>();
			
			String sqlSelectForecastByParkCode = "SELECT * FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue ASC";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectForecastByParkCode, parkCode);
			while (results.next()) {
				aWeather = mapRowSetToWeather(results, tempUnit);
						parkWeather.add(aWeather);
			}
			return parkWeather;
		}	
	
}
