<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>AmeminCollection!!</title>
</head>
<body>
	<h2>Amemin Collection Home</h2>

	<!-- アカウント編集画面へのリンク -->
	<form action="AccountEdit" method="post">
		<input type="submit" value="アカウント">
	</form>
	<!-- デッキ編集画面へのリンク -->
	<form action="DeckHome" method="post">
		<input type="submit" value="デッキ">
	</form>
	<!-- バトル画面へのリンク -->
	<form action="BattleHome" method="post">
		<input type="submit" value="バトル">
	</form>
	<!-- ガチャ画面へのリンク -->
	<form action="GachaHome" method="post">
		<input type="submit" value="ガチャ">
	</form>
</body>
</html>
