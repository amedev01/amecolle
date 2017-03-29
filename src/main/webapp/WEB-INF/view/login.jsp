
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources//css/login.css">
<title>AmeminCollection!!</title>
</head>
<body<%-- background="${pageContext.request.contextPath}/resources/image/background/background.jpg" 見にくいからコメントアウト--%>>

	<table id="loginForm" class="borderless">
		<tr>
			<td class="center borderless" colspan="2">
			<h2>Hello!! This is Amemin Collection!!</h2></td>
		</tr>
					<tr>
			<td  colspan="2" class="borderless">
			<c:if test="${!empty SPRING_SECURITY_LAST_EXCEPTION }" >
				<span style="color: red; font: bold"> <c:out
						value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</span>
				<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
			</c:if>
			</td>
			</tr>
		<form:form action="authenticate" method="post">
			<%-- 	<form:form action="home" method="post"> --%>
			<tr>
				<th colspan="2" class="center">LoginForm</th>
			</tr>
			<tr>
				<th class="center">UserID</th>
				<td><input type="text" name="userId" value=""></td>
			</tr>
			<tr>
				<th class="center">Password</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td align="center" class="borderless"></td>
				<td align="center" class="borderless">
				<input type="submit" class="button center" value="Login">
				<input type="submit" class="button center" formaction="signUp" value="Singup">
					</td>
			</tr>
		</form:form>

		<tr><th class="borderless center"  colspan="2">Admin</th></tr>
		<form:form action="adminHome" method="post">
			<tr><th class="center">UserID</th><td colspan="2" ><input type="text" name="userId" value=""></td></tr>
			<tr><th class="center">Password</th><td  colspan="2" ><input type="password" name="password" /></td></tr>
			<tr>
			<td align="center" class="borderless"></td>
			<td class="borderless center"><input type="submit"  class="button center" value="login"></td>
			</tr>
		</form:form>
	</table>

</body>
</html>