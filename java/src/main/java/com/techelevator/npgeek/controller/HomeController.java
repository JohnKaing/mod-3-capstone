package com.techelevator.npgeek.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class HomeController {
	
	@Autowired
	private ParkDAO somePark;

	@RequestMapping(value= {"/","homePage"})
	public String displayHomePage(ModelMap modelHolder) {
		List<Park> listOfParks = somePark.getAllParks();
		modelHolder.put("parks", listOfParks);
		return "homePage";
		
	}
	
	@RequestMapping(path = "/parkDetail", method = RequestMethod.GET)
	public String showParkDetailPage(@RequestParam String parkCode, ModelMap modelHolder) {
		
		modelHolder.put("parks", somePark.getParkByParkCode(parkCode));

		return "parkDetail";
	}
	
}
