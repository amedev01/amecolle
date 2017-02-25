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
	<h2>Hello!! This is Amemin Collection!! </h2>
	<form action="home" method="post">
		<input type="text" name="userId" value="">
		<input type="password" name="password" />
		<input type="submit" value="ログイン">
	</form>
		<c:url value="/home" var="messageUrl" />
		<a href="${messageUrl}">Let's Play!!</a>
	</body>
</html>
