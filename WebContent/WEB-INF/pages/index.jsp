<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<title>OA</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS Libs -->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/animate.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/bootstrap-switch.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/checkbox3.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/bootstrap3-wysihtml5.css">
<!--  -->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/adminLTE/css/AdminLTE.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/themes/flat-blue.css">

</head>

<body class="flat-blue">


	<%@include file="loader.jsp"%>
	<div class="app-container">
		<div class="row content-container ">
			<%@include file="header.jsp"%>
			<%@include file="navibar.jsp"%>
			<%@include file="content.jsp"%>
		</div>
		<%@include file="footer.jsp"%>
	</div>
	<%@include file="tips.jsp"%>
	<script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/bootstrap-collapse.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/bootstrap-table-locale-all.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/bootstrap3-typeahead.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/moment.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/daterangepicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/bootstrap3-wysihtml5.all.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/app.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/index.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/adminLTE/js/adminlte.min.js"></script>
</body>

</html>