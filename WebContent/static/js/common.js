$(function() {
	//提示信息方法
	jQuery.showTips = function(message){
		$("#op-tips-content").html(message);
		$("#op-tips-dialog").modal("show");
	};
	
	// 清空表单输入框值
	jQuery.clearVal = function(selector){
		$(selector + " input").attr("value"," ");
	};
	
	//提示瞬时消息
	jQuery.shortTips = function(message,time){
		$(".short-tips-content").html(message);
		$("#shortTipsDialog").modal("show");
		setTimeout(function(){
			$("#shortTipsDialog").modal("hide");
		},time);
	};
	
	jQuery.ajaxError = function(XMLHttpRequest, textStatus, errorThrown){
		var info = "";
		console.log(XMLHttpRequest.readyState);
		switch(XMLHttpRequest.readyState)
		{
		case 0:
		  info = "未连接服务器"
		  break;
		default:
		  info = "未知错误"
		}
		$.showTips(info);
	}
	
	// 加载菜单内容
	jQuery.loadURL = function(url) {
		$.ajax({
			type:"post",
			url:url,
			success : function(data) {
				$("#iframe").html(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.ajaxError(XMLHttpRequest, textStatus, errorThrown);
			},
		});
	}
	
	//二次封装ajax
	jQuery.ax = function(url,data,async,type,dataType,successfn,errorfn) {
		//验证参数是否合法("typeof"是用来检测变量的数据类型)
		async = (async == null || async == "" || typeof(async) == "undefined") ? "true" : async;
		type = (type == null || type == "" || typeof(type) == "undefined") ? "post" : type;
		dataType = (dataType == null || dataType == "" || typeof(dataType) == "undefined") ? "json" : dataType;
		data = (data == null || data == "" || typeof(data) == "undefined") ? {"data" : "error"} : data;
		$.ajax({
			type:type,
			async:async,
			data:data,
			url:url,
			dataType:dataType,
			success:function(data) {
				successfn(data);
			},
			error:function(e) {
				errorfn(e);
			}
		});
	};
	
	jQuery.axSync = function(url,data,loading,successfn) {
		loading = (loading == null || loading == "" || typeof(async) == "undefined") ? "body" : loading;
		$.ajax({
			type:"post",
			async:"false",
			data:data,
			url:url,
			beforeSend:function() {
				$(loading).addClass("loader");
			},
			success:function(data) {
				successfn(data);
			},
			complete:function() {
				$(loading).removeClass("loader");
			},
			error:function(e) {
				$.showTips(e);
			}
		});
	};
	
	jQuery.axAsync = function(url,data,successfn) {
		$.ajax({
			type:"post",
			//dataType: "json",
			data:data,
			url:url,
			success:function(data) {
				successfn(data);
			},
			error:function(data) {
				//console.log(data.responseJSON.msg);
				var obj = JSON.parse(data.responseText);
				$.showTips(obj.msg)
				/*console.log(JSON.parse(JSON.stringify(data)).responseText);
				console.log(JSON.stringify(data).responseText)*/
			}
		});
	};
	
	jQuery.axAsync2 = function(url,data) {
		$.ajax({
			type:"post",
			data:data,
			url:url,
			success:function(data) {
				$.shortTips(data,1500);
			},
			error:function(e) {
				$.showTips(e);
			}
		});
	};
	
	jQuery.axAsyncList = function(url,data,successfn) {
		$.ajax({
			type:"post",
			data:data,
			url:url,
			traditional:true,
			success:function(data) {
				successfn(data);
			},
			error:function(data) {
				$.showTips(data);
			}
		});
	};
	
	jQuery.loadTable = function(selector,url,toolbar,uniqueId,columns) {
		$(selector).bootstrapTable({
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			toolbar : toolbar,// 工具按钮用哪个容器
			locale : "zh-CN",// 选择语言
			url : url,// 请求后台的URL(*)
			method : 'post',// 请求方式(*)
			striped : true,// 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性(*)
			pageSize : 10,// 每页的记录行数(*)
			pageList : [ 5, 10, 15, 20, 50],// 可供选择的每页的行数(*)
			pagination : true,// 是否显示分页(*)
			sortable : true,// 是否启用排序
			sortOrder : "asc",// 排序方式
			uniqueId : uniqueId,// 每一行的唯一标识，一般为主键列
			search : true,// 是否显示表格搜索
			clickToSelect : true, // 是否启用点击选中行
			queryParamsType :"limit",// 请求参数类型(*)
			sidePagination : "server",// 分页方式：client客户端分页，server服务端分页(*)
			pageNumber : 1,// 默认加载页
			columns : columns,
			searchOnEnterKey : true,
			onLoadSuccess : function() {
				console.log("数据加载成功！");
			},
			onLoadError : function() {
				$.showTips("数据加载失败！");
			},
			/*onDblClickRow: function (row, $element) {
                var id = row.ID;
                EditViewById(id, 'view');
            },*/
		});
	};
	
	jQuery.loadTable2 = function(selector,url,toolbar,uniqueId,columns,queryParams) {
		/*$(selector).bootstrapTable('hideLoading');*/
		$(selector).bootstrapTable({
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			toolbar : toolbar,// 工具按钮用哪个容器
			/*ajaxOptions : Object*/
			locale : "zh-CN",// 选择语言
			url : url,// 请求后台的URL(*)
			method : 'post',// 请求方式(*)
			striped : true,// 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性(*)
			pageSize : 10,// 每页的记录行数(*)
			pageList : [ 5, 10, 15, 20, 50],// 可供选择的每页的行数(*)
			pagination : true,// 是否显示分页(*)
			sortable : true,// 是否启用排序
			sortOrder : "asc",// 排序方式
			uniqueId : uniqueId,// 每一行的唯一标识，一般为主键列
			search : true,// 是否显示表格搜索
			clickToSelect : true, // 是否启用点击选中行
			queryParams :queryParams,// 请求参数类型(*)
			sidePagination : "server",// 分页方式：client客户端分页，server服务端分页(*)
			pageNumber : 1,// 默认加载页
			columns : columns,
			/*detailView : true,*/
			/*rowStyle : function(row,index) {
				return class;
			}*/
			/*customSearch*/
			onLoadSuccess : function() {
				console.log("数据加载成功！");
			},
			onLoadError : function() {
				$.showTips("数据加载失败！");
			},
			
		});
	};
});