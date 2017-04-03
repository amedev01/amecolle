<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <html> -->
<!-- 	<head> -->
<!-- 		<meta charset="utf-8"> -->
<!-- 		<title>AmeminCollection!!</title> -->
<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"> --%>
<!-- 	</head>  -->
<!-- <body> -->
<%-- 	<form:form action="accountDetail" method="post"> --%>
 	<!-- 	ログアウト	 --> 
<!-- 	<input type="submit" value="ログアウト"  class="button" formaction="logout"> -->
<!-- 	<h1>AdminHome</h1> -->
	
<!-- 	<table> -->
<!-- 		<tr><th>No</th><th>UserId</th><th>Authority</th><th colspan="2">Edit</th></tr> -->
	
<%-- 		<c:forEach var="list" items="${userList}" varStatus="status"> --%>
<!-- 			<tr> -->
<%-- 			<td width="10%"><c:out value="${status.index}" /></td> --%>
<%-- 			<td><c:out value="${list.userId}" /></td> --%>
<!-- 			<td width="10%"> -->
<%-- 			<c:choose> --%>
<%-- 			<c:when test="${list.roleId == '0' }">一般</c:when> --%>
<%-- 			<c:when test="${list.roleId == '1' }">管理</c:when> --%>
<%-- 			<c:otherwise>不明</c:otherwise> --%>
<%-- 			</c:choose> --%>
<!-- 			</td> -->
<%-- 			<td width="10%"><input type="submit" value="詳細" class="button" formaction="accountDetail?id=<c:out value='${list.id}'/>"></td> --%>
<%-- 			<td width="10%"><input type="submit" value="削除"  class="button" formaction="accountEdit/delete?id=<c:out value='${list.id}'/>"></td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
<%-- 	</form:form> --%>
<!-- </body> -->
<!-- </html> -->



<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=11">
  <title>Amecolle!! | Admin Home</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="${pageContext.request.contextPath}/adminHome" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>C<b>!</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Ame</b>Colle<b>!!</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">UserId</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  UserId - Authority
                  <small>Member since DateTime.</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="${pageContext.request.contextPath}/logout" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>your UserId</p>
          <a href="#"><i class="fa fa-circle text-success"></i>your Authority</a>
        </div>
      </div>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        User Data
        <small>you can edit</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>Admin Home</a></li>
<!--         <li><a href="#">Tables</a></li> -->
<!--         <li class="active">Data tables</li> -->
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">

          <!-- /.box -->

          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Select Edit Data</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
  	<form:form action="accountDetail" method="post">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
  		<tr><th>No</th><th>UserId</th><th>Authority</th><th colspan="2">Edit</th></tr>
                </thead>
                <tbody>
	
		<c:forEach var="list" items="${userList}" varStatus="status">
			<tr>
			<td width="10%"><c:out value="${status.index}" /></td>
			<td><c:out value="${list.userId}" /></td>
			<td width="10%">
			<c:choose>
			<c:when test="${list.roleId == '0' }">General</c:when>
			<c:when test="${list.roleId == '1' }">Admin</c:when>
			<c:otherwise>不明</c:otherwise>
			</c:choose>
			</td>
			<td width="10%"><input type="submit" value="Detail" class="btn btn-primary btn-block btn-flat" formaction="accountDetail?id=<c:out value='${list.id}'/>"></td>
			<td width="10%"><input type="submit" value="Delete"  class="btn btn-primary btn-block btn-flat" formaction="accountEdit/delete?id=<c:out value='${list.id}'/>"></td>
			</tr>
		</c:forEach>
  
                </tbody>
                <tfoot>
  		<tr><th>No</th><th>UserId</th><th>Authority</th><th colspan="2">Edit</th></tr>
                </tfoot>
              </table>
	</form:form>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.1.0
    </div>
    <strong>Copyright &copy; 2017 Amedev.</strong> All rights
    reserved.
  </footer>

  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/resources/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
</body>
</html>
