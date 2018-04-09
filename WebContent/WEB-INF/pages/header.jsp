<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<!-- <li><a href="javascript:void(0);"><shiro:principal />,您好!</a></li> -->
			<%-- <li><a href="${pageContext.request.contextPath}/logout">退出</a></li> --%>
			<li><input type="text" id="userId" value="10001"><button type="button" id="login">登录</button></li>
		</ul>
	</div>
</nav>
<script>
	
</script>