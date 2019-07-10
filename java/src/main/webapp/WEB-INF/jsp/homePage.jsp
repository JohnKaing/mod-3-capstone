<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    
<c:import url="/WEB-INF/jsp/header.jsp" />
    
<div id="main-content"> 
		 <c:forEach var="homePark" items="${parks}">
					<div class="hPark">
					<c:url var = "image" value ="/img/parks/${fn:toLowerCase(homePark.parkCode)}.jpg"/>
					<a href="parkDetail?parkCode=${homePark.parkCode}"> <img src="${image}"/> </a>
					<h2>${homePark.parkName}</h2>	
						<ul>
							<li> ${homePark.state}</li>
							<li> ${homePark.parkDescription}</li>
						</ul>
					
					</div>
				</c:forEach>
 