<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<meta charset="utf-8">
<title>AmeminCollection!!</title>
<jsp:include page="../header/header.jsp" flush="true" />
<body>
	<h2>Amemin Collection Home</h2>

	<!-- アカウント編集画面へのリンク -->
	<form action="accountEdit" method="post">
		<input type="submit" value="アカウント">
	</form>
	<!-- デッキ編集画面へのリンク -->
	<form action="deckHome" method="post">
		<input type="submit" value="デッキ">
	</form>
	<!-- バトル画面へのリンク -->
	<form action="battleHome" method="post">
		<input type="submit" value="バトル">
	</form>
	<!-- ガチャ画面へのリンク -->
	<form action="gachaHome" method="post">
		<input type="submit" value="ガチャ">
	</form>
</body>
</html>
