package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
@SessionAttributes("parkDetail")
public class HomeController {
	
	@Autowired
	private ParkDAO somePark;
	
	@Autowired
	private WeatherDAO someForecast;

	@RequestMapping(value= {"/","homePage"})
	public String displayHomePage(ModelMap modelHolder) {
		List<Park> listOfParks = somePark.getAllParks();
		modelHolder.put("parks", listOfParks);
		return "homePage";
		
	}
	
	@RequestMapping(path = "/parkDetail", method = RequestMethod.GET)
	public String showParkDetailPage(HttpServletRequest request, ModelMap modelHolder) {
		String parkCode = request.getParameter("parkCode");
		modelHolder.put("parks", somePark.getParkByParkCode(parkCode));
		modelHolder.put("forecasts", someForecast.getForecastByParkCode(parkCode));

		return "parkDetail";
	}
	
	@RequestMapping(path = "/parkDetail", method = RequestMethod.POST)
	public String showParkDetailPageTemp(HttpServletRequest request, ModelMap modelHolder) {
		String parkCode = request.getParameter("parkCode");
		modelHolder.put("parks", somePark.getParkByParkCode(parkCode));
		modelHolder.put("forecasts", someForecast.getForecastByParkCode(parkCode));
		return "parkDetail";
	}
	
}
