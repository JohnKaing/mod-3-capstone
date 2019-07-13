<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div id="main-content">

	<div id="park-content">
		<c:url var="image"
			value="/img/parks/${fn:toLowerCase(parks.parkCode)}.jpg" />
		<a><img class="images" src="${image}" /> </a>
		<h2>${parks.parkName}</h2>

		<p><b>Park Code:</b><br>				 ${parks.parkCode}</p>
		<p><b>State:</b><br>		 			 ${parks.state}</p>
		<p><b>Acreage:</b> <br>		 			 ${parks.acreage}</p>
		<p><b>Elevation in Feet:</b> <br>		 ${parks.elevationInFeet} FT</p>
		<p><b>Miles of Trail:</b><br>    		 ${parks.milesOfTrail}</p>
		<p><b>Number of Campsites:</b><br>		 ${parks.numberOfCampSites}</p>
		<p><b>Climate:</b>	<br>			  	 ${parks.climate}</p>
		<p><b>Year Founded:</b><br>			     ${parks.yearFounded}</p>
		<p><b>Annual Visitor Count:</b> <br>     ${parks.annualVisitorCount}</p>
		<p><b>Insirational Quote:</b><br>	     ${parks.inspirationalQuote}</p>
		<p><b>Quote Source:</b>	<br>			 ${parks.inspirationalQuoteSource}</p>
		<p><b>Park Description:</b>	<br>		 ${parks.parkDescription}</p>
		<p><b>Entry Fee:</b><br>			   $ ${parks.entryFee}</p>
		<p><b>Number of Animals Species:</b><br> ${parks.numberOfAnimalSpecies}</p>


	</div>

	<c:url var="temperatureUrl" value="/temperatureConversion">
		<c:param name="parkCode">${parks.parkCode}</c:param>
	</c:url>
	<form action="${temperatureUrl}" method="POST">

		<select name="temperature">Select Temperature
			<option value="Fahrenheit">Fahrenheit</option>
			<option value="Celsius">Celsius</option>
		</select> <input type="submit" value="Change Temperature">
	</form>


<table>
				<tr>

	<div id="forecast-content">
		<c:forEach var="parkForecast" items="${forecasts}">
			<c:url var="forecastImage"
				value="/img/weather/${parkForecast.forecast}.png" />
			<c:if test="${parkForecast.forecast eq 'partly cloudy'}">
				<c:url var="forecastImage" value="/img/weather/partlyCloudy.png" />
			</c:if>

			
					<td><a><img src="${forecastImage}" /> </a><br>
					${parkForecast.forecast}<br>
					${parkForecast.high}<br>
					${parkForecast.low}<br>
					${parkForecast.fiveDayForecastValue}<br>
					<c:if test="${parkForecast.forecast eq 'snow'}">
							<label>Pack snowshoes</label>
						</c:if> <c:if test="${parkForecast.forecast eq 'rain'}">
							<label>pack rain gear and wear waterproof shoes</label>
						</c:if> <c:if test="${parkForecast.forecast eq 'thunderstorms'}">
							<label>"Seek shelter and avoid hiking on exposed ridges"</label>
						</c:if> <c:if test="${parkForecast.forecast eq 'sun'}">
							<label>"pack sunblock"</label>
						</c:if> <c:if test="${parkForecast.high > '75'}">
							<label>bring an extra gallon of water</label>
						</c:if> <c:if test="${parkForecast.high - parkForecast.low > '20'}">
							<label>wear breathable layers</label>
						</c:if> <c:if test="${parkForecast.low < '20'}">
							<label>Warning! danger of exposure to frigid temps</label>
						</c:if></td>



			
		</c:forEach>
	</tr>
			</table>
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />
