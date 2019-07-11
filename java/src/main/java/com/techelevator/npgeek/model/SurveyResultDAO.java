package com.techelevator.npgeek.model;

import java.util.List;


public interface SurveyResultDAO {
	
	public List<SurveyResult> getAllPosts();
	public List<FavoritePark> getFavoriteParks();
	public void save(SurveyResult post);

}
