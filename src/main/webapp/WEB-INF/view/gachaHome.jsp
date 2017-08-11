
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<title>AmeminCollection!!</title>
<jsp:include page="../header/header.jsp" flush="true" />
	<body>
	<h2>ガチャホーム画面</h2>
	<form:form modelAttribute="gachaResultForm" action="gachaResult" method="post">
		<form:errors name="gachaResultForm" /> <br />
		<input type="submit">
	</form:form>
	</body>
</html>