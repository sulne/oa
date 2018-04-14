<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="side-menu sidebar-inverse">
	<nav class="navbar navbar-default" role="navigation">
		<div class="">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><span class="icon fa fa-circle-o"></span><span class="title">主菜单</span>
				</a>
			</div>
			<ul class="nav navbar-nav sidebar-menu" data-widget="tree">
				<li class="treeview">
					<a data-toggle="collapse">
						<span class="icon fa fa-user-plus"></span>
						<span class="title">1</span>
					</a>
					<ul class="treeview-menu">
						<li class="treeview">
							<a data-toggle="collapse">
								<span class="title">1.1</span>
							</a>
							<ul class="treeview-menu">
								<li><a data-toggle="collapse"><span class="title">1.1.1</span></a></li>
								<li><a data-toggle="collapse"><span class="title">1.1.2</span></a></li>
							</ul>
						</li>
					</ul>
				</li>
				
				<li class="treeview">
					<a data-toggle="collapse">
						<span class="icon fa fa-user-plus"></span>
						<span class="title">1</span>
					</a>
					<ul class="treeview-menu">
						<li class="treeview">
							<a data-toggle="collapse">
								<span class="title">1.1</span>
							</a>
							<ul class="treeview-menu">
								<li><a data-toggle="collapse"><span class="title">1.1.1</span></a></li>
								<li><a data-toggle="collapse"><span class="title">1.1.2</span></a></li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</div>