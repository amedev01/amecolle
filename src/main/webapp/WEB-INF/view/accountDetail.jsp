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

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Account Details
        <small>you can edit</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/home"><i class="fa fa-dashboard"></i>Admin Home</a></li>
        <li><a href="#">Account Details</a></li>
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
              <h3 class="box-title">Information</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
	<form:form action="${pageContext.request.contextPath}/admin/accountDetail/update" method="post" modelAttribute="accountDetailForm">
	<form:hidden path="id"/>
	 	<table class="table table-bordered table-striped">
		 	<tr><th width="20%">UserID</th><td><form:input path="userId"/></td></tr>
		 	<tr><th width="20%">Password</th><td><form:password path="password"/></td></tr>
		 	<tr><th width="20%">Number of characters</th><td><c:out value="${cardNum}"/> 
		 		<c:choose>
			 		<c:when test="${cardNum <= 1}" >
				 		character.	
			 		</c:when>
			 		<c:otherwise>
				 		characters.	
			 		</c:otherwise>
		 		</c:choose>
		 	</td></tr>
		 	<tr>
		 		<th width="20%">Login time</th>
		 		<td><fmt:formatDate value="${accountDetailForm.latestLoginTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
		 	</tr>
		 	<tr>
		 		<th width="20%">Update time</th>
		 		<td><fmt:formatDate value="${accountDetailForm.updateTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
		 	</tr>
			<tr><td class="borderless" colspan="2">
				<input type="submit" formaction="${pageContext.request.contextPath}/admin/accountDetail/update" value="Edit" class="button">
				<input type="submit" formaction="${pageContext.request.contextPath}/admin/accountDetail/delete" value="Delete" class="button">
				<input type="submit" formaction="${pageContext.request.contextPath}/admin/home" value="Back" class="button">
			</td></tr>
			</table>
			<hr>
		<table class="table table-bordered table-striped">
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