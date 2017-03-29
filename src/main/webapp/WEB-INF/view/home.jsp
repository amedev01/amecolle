
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
	<form:form action="accountEdit" method="post">
		<input type="submit" value="アカウント">
	</form:form> >
	<!-- デッキ編集画面へのリンク -->
	<form:form action="deckHome" method="post">
		<input type="submit" value="デッキ">
	</form:form> >
	<!-- バトル画面へのリンク -->
	<form:form action="battleHome" method="post">
		<input type="submit" value="バトル">
	</form:form> >
	<!-- ガチャ画面へのリンク -->
	<form:form action="gachaHome" method="post">
		<input type="submit" value="ガチャ">
	</form:form> >
</body>
</html>
