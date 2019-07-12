<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div id="main-content">

	<div id="park-content">
		<c:url var="image"
			value="/img/parks/${fn:toLowerCase(parks.parkCode)}.jpg" />
		<a><img src="${image}" /> </a>
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

	</div>
	<%-- 	<c:url var="temperatureUrl" value="parkDetail?parkCode=${parks.parkCode}"/>				
 --%>
	<c:url var="temperatureUrl" value="/temperatureConversion">
		<c:param name="parkCode">${parks.parkCode}</c:param>
	</c:url>
	<form action="${temperatureUrl}" method="POST">
		<%-- 	<input type="hidden" name="parkCode" value="${parks.parkCode}"/>
 --%>
		<select name="temperature">Select Temperature
			<option value="Fahrenheit">Fahrenheit</option>
			<option value="Celsius">Celsius</option>
		</select> <input type="submit" value="Change Temperature">
	</form>

<%-- <c:forEach var = "dailyForecast" items = "${weatherAtPark}">
<c:choose>
	<c:when test = "${dailyForecast.forecast == 'partly cloudy'}">
		<c:url var = "weatherImg" value = "/img/weather/partlyCloudy.png"/>
		<img src = "${weatherImg}" alt = "Forecast Img"/>
		
		<c:if test = "${tempUnit == 'F'}">
			High: ${dailyForecast.highTempF}F - 
			Low: ${dailyForecast.lowTempF}F
		</c:if>
		
		<c:if test = "${tempUnit == 'C'}">	
			High: ${dailyForecast.highTempC}C - 
			Low: ${dailyForecast.lowTempC}C
		</c:if>	
		
	</c:when>
	
	<c:otherwise>
		<c:url var = "weatherImg" value = "/img/weather/${dailyForecast.forecast}.png"/>
		<img src = "${weatherImg}" alt = "Forecast Img"/>
		
		<c:if test = "${tempUnit == 'F'}">
			High: ${dailyForecast.highTempF}F -
			Low: ${dailyForecast.lowTempF}F
		</c:if>

		<c:if test = "${tempUnit == 'C'}">	
			High: ${dailyForecast.highTempC}C -
			Low: ${dailyForecast.lowTempC}C
		</c:if>	
	</c:otherwise>
</c:choose><br/>	 --%>




	<div id="forecast-content">
		<c:forEach var="parkForecast" items="${forecasts}">
			<c:url var="forecastImage"
				value="/img/weather/${parkForecast.forecast}.png" />
			<c:if test="${parkForecast.forecast eq 'partly cloudy'}">
				<c:url var="forecastImage" value="/img/weather/partlyCloudy.png" />
			</c:if>
			<%-- <a><img src="${forecastImage}"/> </a> --%>
			<table>
				<tr>
					<td><a><img src="${forecastImage}" /> </a></td>
					<td>${parkForecast.forecast}</td>
					<td>${parkForecast.high}</td>
					<td>${parkForecast.low}</td>
					<td>${parkForecast.fiveDayForecastValue}</td>
					<td><c:if test="${parkForecast.forecast eq 'snow'}">
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



				</tr>
			</table>
		</c:forEach>

	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />
