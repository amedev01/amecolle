
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>AmeminCollection!!</title>
	</head> 
	<body background="${pageContext.request.contextPath}/resources/image/background/background.jpg">
	<h2>Hello!! This is Amemin Collection!! </h2>
<%-- 	<form:form action="authenticate" method="post"> --%>
	<form:form action="home" method="post">
		<input type="text" name="userId" value="">
		<input type="password" name="password" />
		<input type="submit" value="ログイン">
	</form:form>

	<h2>アカウントを所持していない方</h2>
	<form action="signUp" method="post">
		<input type="submit" value="アカウント作成ページへ">
	</form>

	<h3>管理者ページ</h3>
	<form action="adminHome" method="post">
		<input type="text" name="userId" value="">
		<input type="password" name="password" />
		<input type="submit" value="ログイン">
	</form>

</body>
</html>