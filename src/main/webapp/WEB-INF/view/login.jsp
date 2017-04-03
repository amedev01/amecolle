
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amecolle!! | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <b>Amecolle!! </b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session !</p>

			<c:if test="${!empty SPRING_SECURITY_LAST_EXCEPTION }" >
				<span style="color: red; font: bold"> <c:out
						value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</span>
				<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
			</c:if>

		<form:form action="authenticate" method="post">
      <div class="form-group has-feedback">
        <input type="text" name="userId" class="form-control" placeholder="UserId">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>

      <div class="row">
        <div class="col-xs-12">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        <!-- /.col -->
      </div>
      <div class="row">
        <div class="col-xs-6">
          <input type="submit" class="btn btn-primary btn-block btn-flat" value="SignIn">
        </div>
        <div class="col-xs-6">
		  <input type="submit" class="btn btn-primary btn-block btn-flat" formaction="signUp" value="Singup">
        </div>
        <!-- /.col -->
      </div>
         </div>
   
      </form:form>

<!--     <div class="social-auth-links text-center"> -->
<!--       <p>- OR -</p> -->
<!--       <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using -->
<!--         Facebook</a> -->
<!--       <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using -->
<!--         Google+</a> -->
<!--     </div> -->
    <!-- /.social-auth-links -->

<!--     <a href="#">I forgot my password</a><br> -->
<!--     <a href="register.html" class="text-center">Register a new membership</a> -->

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>











<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="utf-8"> -->
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources//css/login.css"> --%>
<!-- <title>AmeminCollection!!</title> -->
<!-- </head> -->
<%-- <bodybackground="${pageContext.request.contextPath}/resources/image/background/background.jpg" 見にくいからコメントアウト> --%>

<!-- 	<table id="loginForm" class="borderless"> -->
<!-- 		<tr> -->
<!-- 			<td class="center borderless" colspan="2"> -->
<!-- 			<h2>Hello!! This is Amemin Collection!!</h2></td> -->
<!-- 		</tr> -->
<!-- 					<tr> -->
<!-- 			<td  colspan="2" class="borderless"> -->
<%-- 			<c:if test="${!empty SPRING_SECURITY_LAST_EXCEPTION }" > --%>
<%-- 				<span style="color: red; font: bold"> <c:out --%>
<%-- 						value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /> --%>
<!-- 				</span> -->
<%-- 				<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" /> --%>
<%-- 			</c:if> --%>
<!-- 			</td> -->
<!-- 			</tr> -->
<%-- 		<form:form action="authenticate" method="post"> --%>
<!-- 			<tr> -->
<!-- 				<th colspan="2" class="center">LoginForm</th> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<th class="center">UserID</th> -->
<!-- 				<td><input type="text" name="userId" value=""></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<th class="center">Password</th> -->
<!-- 				<td><input type="password" name="password" /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td align="center" class="borderless"></td> -->
<!-- 				<td align="center" class="borderless"> -->
<!-- 				<input type="submit" class="button center" value="Login"> -->
<!-- 				<input type="submit" class="button center" formaction="signUp" value="Singup"> -->
<!-- 					</td> -->
<!-- 			</tr> -->
<%-- 		</form:form> --%>

<!-- 	</table> -->

<!-- </body> -->
<!-- </html> -->