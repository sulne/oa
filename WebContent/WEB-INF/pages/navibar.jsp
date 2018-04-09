<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 菜单栏模块 -->
<div class="side-menu sidebar-inverse">
	<nav class="navbar navbar-default" role="navigation">
		<div class="side-menu-container">
			<div class="navbar-header ">
				<a class="navbar-brand" href="#"> <span
					class="icon fa fa-circle-o"></span> <span class="title">主菜单</span>
				</a>
			</div>

			<ul class="nav navbar-nav">
				<li class="active menu"><a
					target="${pageContext.request.contextPath}/home" class="navibar">
						<span class="icon fa fa-home"></span><span class="title">主页</span>
				</a></li>

				<li class="panel panel-default dropdown menu"><a data-toggle="collapse" href="#navi1"> <span class="icon fa fa-home"></span> <span class="title">个人中心</span></a>
					<div id="navi1" class="panel-collapse collapse">
						<div class="panel-body">
							<ul class="nav navbar-nav">
								<li><a target="${pageContext.request.contextPath}/home" class="navibar">个人信息</a></li>
								<li class="panel panel-default dropdown menu"><a data-toggle="collapse" href="#navi11"> <span class="icon fa fa-home"></span> <span class="title">个人中心</span></a>
									<div id="navi11" class="panel-collapse collapse">
										<div class="panel-body">
											<ul class="">
												<li><a target="${pageContext.request.contextPath}/home" class="navibar">个人信息</a></li>
											</ul>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</nav>
</div>