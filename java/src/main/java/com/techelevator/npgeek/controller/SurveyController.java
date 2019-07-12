package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String showSurveyInput(ModelMap modelHolder) {
		List<Park> listOfParks = somePark.getAllParks();
		modelHolder.put("parks", listOfParks);

		if (!modelHolder.containsAttribute("SurveyResult")) {
			modelHolder.addAttribute("SurveyResult", new SurveyResult());
		}

		return "survey";
	}

	@RequestMapping(path = "/surveyResult", method = RequestMethod.GET)
	public String showSurvey(HttpServletRequest request, ModelMap modelHolder) {
		List<FavoritePark> favoriteParks = SurveyResultDAO.getFavoriteParks();
		modelHolder.put("favParks", favoriteParks);
		return "surveyResult";
	}

	@RequestMapping(path = "/surveyResult", method = RequestMethod.POST)
	public String sendSurveyInput(@Valid @ModelAttribute("SurveyResult") SurveyResult post, BindingResult result,
			RedirectAttributes flash, ModelMap modelHolder) {

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "SurveyResult", result);
			flash.addFlashAttribute("SurveyResult", post);

			return "redirect:/survey";
		}

		SurveyResultDAO.save(post);

		return "redirect:/surveyResult";
	}

}
