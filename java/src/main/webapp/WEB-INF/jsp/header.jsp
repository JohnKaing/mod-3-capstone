<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <c:url value="/css/npgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>
<body>
	<nav>
		<ul>
		
			<c:url value="/img/logo.png" var="logoSrc" />
			
			<img id="coverPic" src="${logoSrc}" alt="parkLogo" />
        	<div class="homeButtons">
            <a href="homePage">Home</a>
            <a href="survey">Survey</a>
        	</div>
		</ul>
	
	</nav>
