package com.techelevator.npgeek.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.FavoritePark;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.SurveyResult;
import com.techelevator.npgeek.model.SurveyResultDAO;
@Controller
public class SurveyController {

	
	@Autowired			
	private SurveyResultDAO SurveyResultDAO;
	
	@Autowired
	private ParkDAO somePark;
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String showSurvey(ModelMap modelHolder) {
		List<Park> parks = new ArrayList<>();
		List<FavoritePark> favoriteParks = SurveyResultDAO.getFavoriteParks();
		for(FavoritePark fp: favoriteParks) {
			parks.add(somePark.getParkByParkCode(fp.getParkCode()));
			
		}
		
		modelHolder.put("parks", parks);
//		List<SurveyResult> surveyResult = SurveyResultDAO.getAllPosts(); 
//		request.setAttribute("post", surveyResult);		
		
		return "surveyResult";		
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyInput(ModelMap modelHolder) {
		List<Park> listOfParks = somePark.getAllParks();
		modelHolder.put("parks", listOfParks);
		return "survey";
	}
	
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.POST)
	public String sendSurveyInput(@ModelAttribute SurveyResult post) {		
		
			SurveyResultDAO.save(post);
			
return "/surveyResult";
	}
}
