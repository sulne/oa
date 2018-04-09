$(function() {
	$.loadTable("#tbUser","user/list","#userToolbar","userId",[
			{field : 'checkbox',checkbox : true,},
			{field : 'userId',title : 'ID',sortable : true},
			{field : 'userName',title : '用户名',sortable : true},
			{field : 'updateTime',title : '更新时间'},
			{field : 'status.statusDesc',title : '状态'},
			{field : 'status.statusId',title : '修改',align : 'center',valign : 'middle',
				formatter : function(value, row, index) {
					var statusId = value;
					var userId = row.userId;
					var result = "<span class='glyphicon glyphicon-user show-user-role' title="+userId+"></span>";
					if(statusId == 1) {
						result += "<span style='margin-left:5px;' class='glyphicon glyphicon-ban-circle disable-user' title="+userId+"></span>";
					} else {
						result += "<span style='margin-left:5px;' class='glyphicon glyphicon-ok-circle enable-user' title="+userId+"></span>";
					}
					result += "<a style='margin-left:5px;' class='glyphicon glyphicon-pencil edit-user' title='编辑' target="+userId+"></a>";
					return result;
				}
			},
		]
	);
	
	//添加
	$(".add-user-btn").click(function() {
		$("#addUser").modal("show");
		$("#addUser .add-user-submit").one("click",function(){
			$.axAsync("user/add",$("#addUserForm").serialize(),function(data){
				$("#addUser").modal("hide");
				$.showTips(data);
				$("#tbUser").bootstrapTable("refresh");
			});
		});
	});
	
	//删除选中
	$(".delete-checked-user-btn").click(function() {
		var userArray = $("#tbUser").bootstrapTable("getSelections");
		if(userArray < 1) {
			$.showTips("未选择数据")
		} else {
			$("#CheckedUserTips").modal('show');
			var userIds=[];
        	for(var i=0;i<userArray.length;i++){
        		userIds[i]=userArray[i].userId;
        	}
        	$("#CheckedUserSubmit").one('click',function(){
        		$("#CheckedUserTips").modal('hide');
        		$.axAsyncList("user/batchDelete",{"userIds":userIds},function(data){
        			$.showTips(data);
        			$("#tbUser").bootstrapTable("refresh");
        		});
        	});
		}
	});
	
	//禁用选中
	$(".disabled-checked-user-btn").click(function() {
		var userArray = $("#tbUser").bootstrapTable("getSelections");
		if(userArray < 1) {
			$.showTips("未选择数据")
		} else {
			$("#CheckedUserTips").modal('show');
			var userIds=[];
        	for(var i=0;i<userArray.length;i++){
        		userIds[i]=userArray[i].userId;
        	}
        	$("#CheckedUserSubmit").one('click',function(){
        		$("#CheckedUserTips").modal('hide');
        		$.axAsyncList("user/batchDisabled",{"userIds":userIds},function(data){
        			$.showTips(data);
        			$("#tbUser").bootstrapTable("refresh");
        		});
        	});
		}
	});
	
	//启用选中
	$(".enable-checked-user-btn").click(function() {
		var userArray = $("#tbUser").bootstrapTable("getSelections");
		if(userArray < 1) {
			$.showTips("未选择数据")
		} else {
			$("#CheckedUserTips").modal('show');
			var userIds=[];
        	for(var i=0;i<userArray.length;i++){
        		userIds[i]=userArray[i].userId;
        	}
        	$("#CheckedUserSubmit").one('click',function(){
        		$("#CheckedUserTips").modal('hide');
        		$.axAsyncList("user/batchEnable",{"userIds":userIds},function(data){
        			$.showTips(data);
        			$("#tbUser").bootstrapTable("refresh");
        		});
        	});
		}
	});
	
	//停用用户
	$("#tbUser").on("click",".disable-user",function(){
		var userId = $(this).attr("title");
		$.axAsync2("user/disabled",{"userId":userId});
		$("#tbUser").bootstrapTable("refresh");
	});

	//启用用户
	$("#tbUser").on("click",".enable-user",function(){
		var userId = $(this).attr("title");
		$.axAsync2("user/enable",{"userId":userId});
		$("#tbUser").bootstrapTable("refresh");
	});
	
	//查看角色
	$("#tbUser").on("click",".show-user-role",function(){
		var userId = $(this).attr("title");
		$("#showRole .userId").html(userId);
		$("#showRole").modal("show");
		$("#tbUserRole").bootstrapTable("destroy");
		$.loadTable2("#tbUserRole","user/showRole","","roleId",
				[
					{field : 'checkbox',checkbox :true,formatter : function(value, row, index){
						console.log(row.userRole.userId);
						if(userId == row.userRole.userId) {
							return {
								checked:true,
							};
						}
						return value;
					}},
					{field: 'roleId',title: 'ID',sortable : true},
					{field: 'roleName',title: '角色名'},
					{field: 'roleDesc',title: '描述'},
					{field: 'roleCode',title: '代码'},
				],
				function(params) {
					var page = {   
	                        pageSize: params.limit,                         
	                        pageCurrent: params.offset, 
	                        searchText: params.search, 
	                        sortName: params.sort,      
	                        sortOrder: params.order,
	                        userId: userId,
	                    };
					return page;
				}
			
		);
	});
	
	$('#tbUserRole').on('uncheck.bs.table check.bs.table check-all.bs.table uncheck-all.bs.table',function(e,rows){
        var datas = $.isArray(rows) ? rows : [rows];        // 点击时获取选中的行或取消选中的行
        examine(e.type,datas);
	});
	
	function examine(type,datas){           // 操作类型，选中的行
		var userId = $("#showRole .userId").html();
	    if(type.indexOf('uncheck')==-1){    
	        $.each(datas,function(i,v){ 
	        	$.axAsync2("user/addRole",{"roleId":v.roleId,"userId":userId});
	        });
	    }else{
	        $.each(datas,function(i,v){        
	            $.axAsync2("user/delRole",{"roleId":v.roleId,"userId":userId});
	        });
	    }
	}
	//编辑角色结束
	
	//修改密码
	$("#tbUser").on("click",".edit-user",function(){
		var userId = $(this).attr("target");
		$.axAsyncList("user/getUser",{"userId":userId},function(data) {
			$("#editUser input[name=userId]").val(data.userId);
			$("#editUser input[name=email]").val(data.email);
			$("#editUser input[name=phone]").val(data.phone);
			$("#editUser input[name=userName]").val(data.userName);
			$("#editUser").modal("show");
			$(".edit-user-submit").one("click",function(){
				$.axAsyncList("user/editUser",$("#editUserForm").serialize(),function(data){
					$.shortTips(data,1500);
				})
			});
		});
	});
});
