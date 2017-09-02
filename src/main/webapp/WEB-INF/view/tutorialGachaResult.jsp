<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<title>AmeminCollection!!</title>
<jsp:include page="../header/header.jsp" flush="true" />
	<body>
	<h2>ガチャ結果画面</h2>
		<c:out value="${pullOne.cardName}" />
	</body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=11">
  <title>Amecolle!! | ガチャ結果</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <jsp:include page="../include/css.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

<!--  sec:authentication property="principal.username" var="userId" />
-->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Home
        <small>Your Performance</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/home"><i class="fa fa-dashboard"></i>Home</a></li>
<!--         <li><a href="#">Your Performance</a></li> -->
<!--         <li class="active">Data tables</li> -->
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
			<c:forEach var="cardList" items="${cardList}" >
				<c:out value="${cardList.cardName}"/>
			</c:forEach> 
<!-- /.box -->
<!-- /// -->
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Information</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            
            
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