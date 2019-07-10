package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.SurveyResult;
import com.techelevator.npgeek.model.SurveyResultDAO;

public class SurveyController {

	
	@Autowired			
	private SurveyResultDAO SurveyResultDAO;
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String showSurvey(HttpServletRequest request) {
		
		List<SurveyResult> surveyResult = SurveyResultDAO.getAllPosts(); 
		
		request.setAttribute("post", surveyResult);		
		
		return "surveyResult";		
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyInput() {
		
		return "survey";
	}
	
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String sendSurveyInput(@ModelAttribute SurveyResult post) {		
		
			SurveyResultDAO.save(post);
			
return "redirect:/surveyResult";
	}
}
