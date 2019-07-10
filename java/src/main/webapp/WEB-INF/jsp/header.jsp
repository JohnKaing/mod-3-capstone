<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
<%-- 			<c:url value="/img/ssg_logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="Solar System Geek logo" /> --%>
		
			<c:url value="/img/logo.png" var="logoSrc" />
			<img src="${logoSrc}" alt="park logo" />
		    <h2>National Park Geek</h2>
        <ul>
            <li><a href="homePage">Home</a></li>
            <li><a href="survey">Survey</a></li>
        </ul>
		</ul>
	
	</nav>

</body>
</html>