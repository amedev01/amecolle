<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>アカウント作成</h2>
	<h4>新規IDとパスワードを入力してください。</h4>
	<form:form action="signUp/exec" method="post">
		<input type="text" name="userId" value="">
		<input type="password" name="password" /><br />
		権限 :
		<select name="roleId">
			<option value="0">一般</option>
			<option value="1">管理</option>
		</select>
		<input type="submit" value="アカウント作成">
	</form:form>
</body>
</html>