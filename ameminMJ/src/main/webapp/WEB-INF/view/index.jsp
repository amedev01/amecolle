<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>AmeminCollection!!</title>
	</head> 
	<body>
	<h1>Hello!! This is Amemin Collection!! </h1>
		<c:url value="/play" var="messageUrl" />
		<a href="${messageUrl}">Let's Play!!</a>
	</body>
</html>
