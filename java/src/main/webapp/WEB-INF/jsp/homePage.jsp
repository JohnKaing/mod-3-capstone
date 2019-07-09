<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:import url="/WEB-INF/jsp/header.jsp" />
    
<!DOCTYPE html>
<html>

<body>

   <c:forEach var="park" items="${parks}">
   <c:url value="/img/parks/${park.parkCode}.png" var="parkImage"/>
   <td><img src="${parkImage}"/></td>
   <h2>${park.parkName}</h2>
   <p>${park.parkDescription}</p>	
   
</c:forEach>

 testing
</body>
</html>