<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=11">
  <title>Amecolle!! | Home</title>
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
        
        <!-- /.box -->
          
          <div class="box">
            <div class="box-header">
            <h3 class="box-title">Battle</h3>
            </div>

            <!-- /.box-header -->
            
            <div class="box-body">
            <b><c:out value="あなたのデッキ情報"/></b>
        <br />
        <table class="battleHome">
        <tr>
        	<c:forEach var="list" items="${deckHomeForm.mCardList}" varStatus="idx">
        	<td><c:out value="Rarelity" />&nbsp;
        		<c:out value="Card" />
        	</td>
        	<td>
        		☆<c:out value="${list.rarity }" />&nbsp;
        		 <c:out value="${list.cardName }" />
        	</td>
        </c:forEach>
        </tr>
        <tr>
		    <c:out value="${deckEntity.deckId}" />
			<c:out value="${deckEntity.deckName}" />
			<c:out value="${mCardEntity1.hitPoint}" />
			<c:out value="${mCardEntity1.attack}" />
			<c:out value="${deckEntity.card1}" />
			<c:out value="${deckEntity.card2}" />
			<c:out value="${deckEntity.card3}" />
		</tr>
		</table>
		<br /> <br />
		
			<b><c:out value="相手のデッキ情報"/></b>
		<br />
		    <c:out value="${enemyDeckEntity.deckId}" />
			<c:out value="${enemyDeckEntity.deckName}" />
			<c:out value="${enemyCardEntity1.hitPoint}" />
			<c:out value="${enemyCardEntity1.attack}" />
			<c:out value="${enemyDeckEntity.card1}" />
			<c:out value="${enemyDeckEntity.card2}" />
			<c:out value="${enemyDeckEntity.card3}" />
		<br /> <br />
            
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