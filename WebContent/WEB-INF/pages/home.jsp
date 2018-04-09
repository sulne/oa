<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<input type="text" data-provide="typeahead" autocomplete="off" id="input">
<input type="text" id="hidden">
<input type="text" class="" id="startDate" size="6">

<script type="text/javascript">
	$(document).ready(function() {
		$('#startDate').daterangepicker({
			"singleDatePicker": true,
			"showDropdowns" : true,
			"locale" : {
				"format" : 'YYYY-MM-DD',
              },
			"startDate" : moment(),
            });
      });
</script>