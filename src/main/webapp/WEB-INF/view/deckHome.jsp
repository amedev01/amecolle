
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<title>AmeminCollection!!</title>
<jsp:include page="../header/header.jsp" flush="true" />
	<body>
	<h2>デッキホーム画面やで</h2>
	<form:form action="deckEdit" method="post">
		<input type="submit">
	</form:form>
	</body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=11">
  <title>Amecolle!! | Deck Edit</title>
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
        Deck Home
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
              <h3 class="box-title">Deck</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            <form:form action="deckEdit" modelAttribute="deckHomeForm" >
            <form:errors path="*" cssStyle="color:red"/>
            <table class="deckHome" >
            <tr>
            	<c:forEach var="list" items="${deckHomeForm.deckCardList}" varStatus="status">
            	<c:set var="idx" value="${status.index }"></c:set>
            	<th>
            		<form:radiobutton path="outDeck" value="${idx + 1}"/>&nbsp;
	               	☆<c:out value="${list.rarity }" />&nbsp;
	               <c:out value="${list.cardName }" />
            	</th>
            	</c:forEach>
            </tr>
            <tr>
            	<c:forEach var="list" items="${deckHomeForm.deckCardList}" varStatus="idx">
            	<td>
					<img alt="card" src="${list.url }" width="150" height="200">
				</td>
            	</c:forEach>
            </tr>
            <tr>
            	<c:forEach var="list" items="${deckHomeForm.deckCardList}" >
            	<td>
	               HP : <c:out value="${list.hitPoint }" />&nbsp;
	               ATK : <c:out value="${list.attack }" />
            	</td>
            	</c:forEach>
            </tr>
            </table>
            <form:button value="変更">変更</form:button>
            <hr>
            
            <table>
            	<tr>
            		<th>No</th>
            		<th>Change</th>
            		<th>Card</th>
            		<th>Rarity</th>
            		<th>Attack</th>
            		<th>HP</th>
            	</tr>
            	<c:forEach var="list" items="${deckHomeForm.userCardList}" varStatus="status">
            	<c:set var="idx" value="${status.index + 1}"></c:set>
            		<tr>
            			<td><c:out value="${idx}"></c:out></td>
            			<td><input type="radio" name="inDeck" value="${list.cardId}"/></td>
            			<td><c:out value="${list.cardName }" /></td>
            			<td>☆<c:out value="${list.rarity }" /></td>
            			<td>HP : <c:out value="${list.hitPoint }" /></td>
            			<td>ATK : <c:out value="${list.attack  }" /></td>
            		</tr>
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