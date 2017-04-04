<sec:authentication property="principal.username" var="userId" />

<sec:authorize access="hasAuthority('user')" >User</sec:authorize>
                  
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