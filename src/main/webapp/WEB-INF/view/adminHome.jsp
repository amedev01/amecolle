<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=11">
  <title>Amecolle!! | Admin Home</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <jsp:include page="../include/css.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

<sec:authentication property="principal.username" var="userId" />

  <header class="main-header">
	<jsp:include page="../include/header.jsp"></jsp:include>
  </header>
  
  <aside class="main-sidebar">
	<jsp:include page="../include/sidebar.jsp"></jsp:include>
  </aside>

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
  	<form:form action="${pageContext.request.contextPath}/admin/accountDetail" method="post">
              <table id="paging" class="table table-bordered table-striped">
                <thead>
			  		<tr>
				  		<th>No</th>
				  		<th>User ID</th>
				  		<th>Authority</th>
				  		<th>Login time</th>
				  		<th>Show Detail</th>
				  		<th>Delete Account</th>
			  		</tr>
                </thead>
                <tbody>
	
		<c:forEach var="list" items="${userList}" varStatus="status">
			<tr>
			<td width="10%"><c:out value="${status.index + 1}" /></td>
			<td><c:out value="${list.userId}" /></td>
			<td width="10%">
			<c:choose>
			<c:when test="${list.roleId == '0' }">User</c:when>
			<c:when test="${list.roleId == '1' }">Admin</c:when>
			<c:otherwise>不明</c:otherwise>
			</c:choose>
			</td>
			<td width="20%"><fmt:formatDate value="${list.latestLoginTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
			<td width="10%"><input type="submit" value="Detail" class="btn btn-primary btn-block btn-flat" formaction="${pageContext.request.contextPath}/admin/accountDetail?id=<c:out value='${list.id}'/>"></td>
			<td width="10%"><input type="submit" value="Delete"  class="btn btn-primary btn-block btn-flat" formaction="${pageContext.request.contextPath}/admin/accountDetail/delete?id=<c:out value='${list.id}'/>"></td>
			</tr>
		</c:forEach>
  
                </tbody>
                <tfoot>
			  		<tr>
				  		<th>No</th>
				  		<th>User ID</th>
				  		<th>Authority</th>
				  		<th>Login time</th>
				  		<th>Show Detail</th>
				  		<th>Delete Account</th>
			  		</tr>
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
	<jsp:include page="../include/footer.jsp"></jsp:include>
  </footer>

  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../include/script.jsp"></jsp:include>

</body>
</html>
