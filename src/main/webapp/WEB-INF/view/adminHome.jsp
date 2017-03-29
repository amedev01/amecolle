<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>AmeminCollection!!</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources//css/main.css">
	</head> 
<body>
	<h1>AdminHome</h1>
	
	<form:form action="accountDetail" method="post">
	<table>
		<tr><th>No</th><th>UserId</th><th>Authority</th><th colspan="2">Edit</th></tr>
	
		<c:forEach var="list" items="${userList}" varStatus="status">
			<tr>
			<td width="10%"><c:out value="${status.index}" /></td>
			<td><c:out value="${list.userId}" /></td>
			<td width="10%">
			<c:choose>
			<c:when test="${list.roleId == '0' }">一般</c:when>
			<c:when test="${list.roleId == '1' }">管理</c:when>
			<c:otherwise>不明</c:otherwise>
			</c:choose>
			</td>
			<td width="10%"><input type="submit" value="詳細" formaction="accountDetail?id=<c:out value='${list.id}'/>"></td>
			<td width="10%"><input type="submit" value="削除" formaction="adminHome/delete?id=<c:out value='${list.id}'/>"></td>
			</tr>
		</c:forEach>
	</table>
	</form:form>
</body>
</html>