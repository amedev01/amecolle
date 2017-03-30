<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>AmeminCollection!!</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
	</head> 
<body>
	<form:form action="accountEdit" method="post" modelAttribute="adminDetailForm">
	<!-- 	ログアウト	 -->
	<input type="submit" value="ログアウト" class="button"  formaction="logout">
	<h1>AccountDetail</h1>
	<form:hidden path="id"/>
 	<table class="borderless">
 	<tr><th>UserID</th><td><form:input path="userId"/></td></tr>
 	<tr><th>Password</th><td><form:password path="password"/></td></tr>
 	<tr><th>Number of characters</th><td><c:out value="${cardNum}"/> 
 		<c:choose>
 		<c:when test="${cardNum == '1'}" >
 		character.	
 		</c:when>
 		<c:otherwise>
 		characters.	
 		</c:otherwise>
 		</c:choose>
 	</td></tr>
	<tr><td class="borderless">
		<input type="submit" formaction="accountEdit" value="変更" class="button">
		<input type="submit" formaction="accountEdit/delete" value="削除" class="button">
		<input type="submit" formaction="adminHome" value="戻る" class="button">
	</td></tr>
	</table>
	
	<hr>
	
	<table>
	<tr><th colspan="4">CardList</th></tr>
		<tr>
			<th>Rarity</th>
			<th>Name</th>
			<th>HP</th>
			<th>Attack</th>
		</tr>
	<c:forEach var="cardId" items="${cardIdList}">
		<c:forEach var="mCard" items="${mCardList}">
			<c:if test="${cardId == mCard.cardId}">
				<tr>
					<td><c:out value="${mCard.rarity }"/></td>
					<td><c:out value="${mCard.cardName }"/></td>
					<td><c:out value="${mCard.hitPoint }"/></td>
					<td><c:out value="${mCard.attack }"/></td>
				</tr>
			</c:if>			
		</c:forEach>
	</c:forEach> 	
	</table>
	</form:form>
</body>
</html>