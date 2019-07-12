package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String showParkDetailPage(@RequestParam String parkCode, ModelMap modelHolder, HttpSession session) {
		String temp = (String)session.getAttribute("temp");
		if(temp == null) {
			temp = "F";
			session.setAttribute("tempConversion", temp);
		}
		
		Park aPark = somePark.getParkByParkCode("parkCode");
		modelHolder.put("parks", aPark);
		modelHolder.put("forecasts", someForecast.getForecastByParkCode(parkCode));

		return "parkDetail";
	}
	
	@RequestMapping(path = "/temperatureConversion", method = RequestMethod.POST)
	public String showParkDetailPageTemp(HttpSession session, @RequestParam String temperature, @RequestParam String parkCode) {
		if(temperature.startsWith("F")) {
			session.setAttribute("temp", "F");
		}
		else if(temperature.startsWith("C")) {
			session.setAttribute("temp", "C");
		}
		
//		String parkCode = request.getParameter("parkCode");
//		modelHolder.put("parks", somePark.getParkByParkCode(parkCode));
//		modelHolder.put("forecasts", someForecast.getForecastByParkCode(parkCode));
		return "redirect:/parkDetail?parkCode=" + parkCode;
	}
	
}
