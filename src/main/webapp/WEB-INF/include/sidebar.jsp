<sec:authentication property="principal.username" var="userId" />
<script>
function navi(to){
	document.home.action = to;
	document.home.submit();
}
</script>
<sec:authorize access="hasAuthority('user')" >
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><c:out value="${userId}"/></p>
          <a href="#"><i class="fa fa-circle text-success"></i>
                  <sec:authorize access="hasAuthority('admin')" >Admin</sec:authorize>
                  <sec:authorize access="hasAuthority('user')" >User</sec:authorize>
          </a>
        </div>
      </div>
      <!-- sidebar menu: : style can be found in sidebar.less -->
	<form:form name="home" action="" method="post">
		<input type="hidden" name="id"/>
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li>
          <a href=""  onclick="navi('battleHome');return false;" >
            <i class="fa fa-th"></i> <span>PLAY GAME</span>
          </a>
        </li>
        <li>
          <a href=""  onclick="navi('deckHome');return false;" >
            <i class="fa fa-th"></i> <span>DECK EDIT</span>
          </a>
        </li>
        <li>
          <a href=""  onclick="navi('gachaHome');return false;" >
            <i class="fa fa-th"></i> <span>GACHA</span>
          </a>
        </li>
        <li>
          <a href=""  onclick="navi('accountDetail');return false;" >
            <i class="fa fa-th"></i> <span>PROFILE</span>
          </a>
        </li>

      </ul>
	</form:form>
    </section>
    <!-- /.sidebar -->
</sec:authorize>    
<sec:authorize access="hasAuthority('admin')" >
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><c:out value="${userId}"/></p>
          <a href="#"><i class="fa fa-circle text-success"></i>
                  <sec:authorize access="hasAuthority('admin')" >Admin</sec:authorize>
                  <sec:authorize access="hasAuthority('user')" >User</sec:authorize>
          </a>
        </div>
      </div>
    </section>
    <!-- /.sidebar -->
</sec:authorize>