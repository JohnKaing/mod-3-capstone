package com.techelevator.npgeek.model;

import java.util.List;


public interface SurveyResultDAO {
	
	public List<SurveyResult> getAllPosts();
	public void save(SurveyResult post);

}
