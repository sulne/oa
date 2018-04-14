<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%> --%>
<!-- 顶部模块 -->
<nav class="navbar navbar-inverse navbar-fixed-top navbar-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-expand-toggle">
				<i class="fa fa-bars icon"></i>
			</button>
			<!-- <ol class="breadcrumb navbar-breadcrumb">
				<li class="active">Home</li>
				<li class="">User</li>
			</ol> -->
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown notifications-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-bell-o"></i><span class="badge warning">42</span> </a>
				<ul class="dropdown-menu">
					<li class="header">You have 10 notifications</li>
					<li>
						<!-- inner menu: contains the actual data -->
						<ul class="menu">
							<li><a href="#"><i class="fa fa-users text-aqua"></i> 5 new members joined today </a></li>
							<li><a href="#"><i class="fa fa-warning text-yellow"></i> Very long description </a></li>
						</ul>
					</li>
					<li class="footer"><a href="#">View all</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="true">${user.username}<span class="caret"></span>
			</a>
				<ul class="list-group dropdown-menu">
					<li class="list-group-item"><a href="#"> <i class="fa fa-user fa-fw"></i>个人中心
					</a></li>
					<li class="list-group-item"><a href="${pageContext.request.contextPath}/logout"> <i class="fa fa-sign-out fa-fw"></i>安全退出
					</a></li>
				</ul></li>
			<%-- <li><a href="javascript:void(0);"><!-- <shiro:principal /> -->${user.id},您好!</a></li> --%>
			<%-- <li><a href="${pageContext.request.contextPath}/logout">退出</a></li> --%>
		</ul>
	</div>
</nav>
<script>
	
</script>