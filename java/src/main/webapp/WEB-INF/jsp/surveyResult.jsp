<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:forEach var="surveys" items="${favParks}">

	<c:url var="parkImage"
		value="/img/parks/${fn:toLowerCase(surveys.parkCode)}.jpg" />

	<table>

		<tr>
			<th><img class="tableImages" src="${parkImage}"></th>
			
			<td>${surveys.parkName}</td>
			<td>Number of Ratings: ${surveys.count}</td>

		</tr>

	</table>

</c:forEach>



<c:import url="/WEB-INF/jsp/footer.jsp" />