<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    
<c:import url="/WEB-INF/jsp/header.jsp" />
    
<div id="main-content"> 
		 <c:forEach var="homePark" items="${parks}">
					<div class="hPark">
					<c:url var = "image" value ="/img/parks/${fn:toLowerCase(homePark.parkCode)}.jpg"/>
				<table>

		<tr>
					<th><a href="parkDetail?parkCode=${homePark.parkCode}"> <img class="images" src="${image}"/> </a></th>
					<ul>
					<td><h2>${homePark.parkName}</h2></td>
						
							<td> ${homePark.state}</td>
							<td> ${homePark.parkDescription}</td>
						
						</ul>
						</tr>

	</table>
					</div>
				</c:forEach>
 
 <c:import url="/WEB-INF/jsp/footer.jsp" />