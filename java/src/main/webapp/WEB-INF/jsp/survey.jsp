<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<c:import url="/WEB-INF/jsp/header.jsp" />


   <h2>Survey</h2>
			<form action="surveyInput" method="POST">
					<!-- <label for="favoriteNationalPark">favorite National Park: </label>
					<input type="text" name="username" id="username" /> -->
				
			
					<label for="yourEmail">Your Email: </label>
					<input type="text" name="subject" id="subject" />
			
				
<!-- 					<label for="stateOfResidence">State Of Residence: </label>
					<textarea name="message" id="message" rows="10" cols="30"></textarea> -->
				
				
					<label for="yourEmail">Your Email: </label>
					<input type="text" name="subject" id="subject" />
					
					<input type="submit" value="Post" />
					
			</form>
   