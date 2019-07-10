<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    
<c:import url="/WEB-INF/jsp/header.jsp" />
    
<div id="main-content"> 

<c:url var = "image" value ="/img/parks/${fn:toLowerCase(parks.parkCode)}.jpg"/>
					<a><img src="${image}"/> </a>
					<h2>${parks.parkName}</h2>
					<ul>
					<li>${parks.parkCode}</li>
					<li>${parks.state}</li>
					<li>${parks.acreage}</li>
					<li>${parks.elevationInFeet}</li>
					<li>${parks.milesOfTrail}</li>
					<li>${parks.numberOfCampSites}</li>
					<li>${parks.climate}</li>
					<li>${parks.yearFounded}</li>
					<li>${parks.annualVisitorCount}</li>
					<li>${parks.inspirationalQuote}</li>
					<li>${parks.inspirationalQuoteSource}</li>
					<li>${parks.parkDescription}</li>
					<li>${parks.entryFee}</li>
					<li>${parks.numberOfAnimalSpecies}</li>
					</ul>





<!-- parkcode
parkname
state
acreage
elevationinfeet
milesoftrail
numberofcampsites
climate
yearfounded
annualvisitorcount
inspirationalquote
inspirationalquotesource
parkdescription
entryfee
numberofanimalspecies -->