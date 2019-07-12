<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/header.jsp" />
    <h2>test</h2>
    
    
    <c:forEach var="surveys" items = "${favParks}">
    
    <c:url var="parkImage" value="/img/parks/${fn:toLowerCase(surveys.parkCode)}.jpg"/>
    
    <table>
    
    <tr>
    <th><img src= "${parkImage}"></th>
    <th>National Park Name</th>
 <td>${surveys.parkName}</td>
 <td>${surveys.count}</td>
    
    </tr>
    
    </table>
    
    </c:forEach>
    
    
    
<c:import url="/WEB-INF/jsp/footer.jsp" />