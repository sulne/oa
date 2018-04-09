$(function() {
	var overAllIds = new Set(); 
	
	$.loadTable("#tbRole","role/list","#roleToolbar","roleId",[
			{field : 'checkbox',checkbox : true,},
			{field : 'roleId',title : 'ID',sortable : true},
			{field : 'roleName',title : '角色名',sortable : true},
			{field : 'roleDesc',title : '角色描述'},
			{field : 'roleCode',title : '代码'},
			{field : 'icon',title : '图标'},
			{field : 'roleId',title : '操作',align : 'center',valign : 'middle',
				formatter : function(value, row, index) {
					var result = "<a class='glyphicon glyphicon-edit view-role' title='查看' target="+value+"></a>";					
					result += "<a style='margin-left:5px;' class='fa fa-wrench set-user' title='授予用户' target="+value+"></a>";
					result += "<a style='margin-left:5px;' class='fa fa-gear show-role-perm' title='查看权限' target="+value+"></a>";
					return result;
				}
			},
		]
	);
	
	
	//显示角色权限
	$("#tbRole").on("click",".show-role-perm",function(){
		var roleId = $(this).attr("target");
		$("#showPerm .roleId").html(roleId);
		$("#showPerm").modal("show");
		$("#tbRolePerm").bootstrapTable("destroy");
		$.loadTable2("#tbRolePerm","role/showPerm","#rolePermToolbar","permissionId",
				[
					{field : 'checkbox',checkbox :true,formatter : function(value, row, index){
						if(roleId == row.rolePerm.roleId) {
							return {
								checked:true,
							};
						}
						return value;
					}},
					{field: 'permissionId',title: 'ID',sortable : true},
					{field: 'permissionDesc',title: '描述'},
					{field: 'url',title: '地址'},
					{field: 'isNavigation',title: '导航'},
					{field: 'permissionCode',title: '代码'},
				],
				function(params) {
					var limit = {   
							limit: params.limit,                         
							offset: params.offset, 
							search: params.search, 
							sort: params.sort,      
							order: params.order,
	                        roleId: roleId,
	                    };
					return limit;
				}
			
		);
	});
	
	//编辑角色权限
	$('#tbRolePerm').on('uncheck.bs.table check.bs.table check-all.bs.table uncheck-all.bs.table',function(e,rows){
        var datas = $.isArray(rows) ? rows : [rows];        // 点击时获取选中的行或取消选中的行
        examine(e.type,datas);                                
	});
	
	function examine(type,datas){           // 操作类型，选中的行
		var roleId = $("#showPerm .roleId").html();
	    if(type.indexOf('uncheck')==-1){    
	        $.each(datas,function(i,v){
	        	//添加权限
	        	$.axAsync2("role/addPerm",{"roleId":roleId,"permissionId":v.permissionId});
	        });
	    }else{
	        $.each(datas,function(i,v){
	        	//删除权限
	            $.axAsync2("role/delPerm",{"roleId":roleId,"permissionId":v.permissionId});
	        });
	    }
	}
	
	//添加角色
	$(".add-role-btn").click(function() {
		$("#addRole").modal("show");
		$("#addRole .add-role-submit").one("click",function(){
			$.axAsync("role/add",$("#addRoleForm").serialize(),function(data){
				$("#addRole").modal("hide");
				$.clearVal("#addEmp");
				$.showTips(data);
				$("#tbRole").bootstrapTable("refresh");
			});
		});
	});
	
	//查看角色
	$("#tbRole").on("click",".view-role",function(){
		var roleId = $(this).attr("target");
		$.clearVal("#viewRole");
		$.axAsync("role/view",{"roleId":roleId},function(role) {
				$("#viewRole input[name=roleId]").attr("value", role.roleId);
				$("#viewRole input[name=roleName]").attr("value", role.roleName);
				$("#viewRole input[name=roleDesc]").attr("value", role.roleDesc);
				$("#viewRole input[name=roleCode]").attr("value", role.roleCode);
				$("#viewRole input[name=icon]").attr("value", role.icon);
				$("#viewRole").modal("show");
			}
		);
		//编辑角色
		$(".edit-role-submit").one("click",function(){
			$.axAsync("role/edit",$("#editRoleForm").serialize(),function(data){
				$("#viewRole").modal("hide");
				$.showTips(data);
				$("#tbRole").bootstrapTable("refresh");
			});
		});
	});
	
	
	//授角用户
	$("#tbRole").on("click",".set-user",function(){
		var roleId = $(this).attr("target");
		$("#showRoleUser .roleId").html(roleId);
		$("#showRoleUser").modal("show");
		$("#tbRoleUser").bootstrapTable("destroy");
		$.loadTable2("#tbRoleUser","user/getRoleUser","#roleUserToolbar","userId",
				[
					{field : 'checkbox',checkbox :true,formatter : function(value, row, index){
						if(roleId == row.userRole.roleId) {
							return {
								checked:true,
							};
						}
						return value;
					}},
					{field: 'userId',title: 'ID',sortable : true},
					{field: 'userName',title: '用户名'},
				],
				function(params) {
					var limit = {   
							limit: params.limit,                         
							offset: params.offset, 
							search: params.search, 
							sort: params.sort,      
							order: params.order,
							roleId: roleId,
	                    };
					return limit;
				}
			
		);
	});
	
	$('#tbRoleUser').on('uncheck.bs.table check.bs.table check-all.bs.table uncheck-all.bs.table',function(e,rows){
        var datas = $.isArray(rows) ? rows : [rows];        // 点击时获取选中的行或取消选中的行
        examine(e.type,datas);
	});
	
	function examine(type,datas){           // 操作类型，选中的行
		var roleId = $("#showRoleUser .roleId").html();
	    if(type.indexOf('uncheck')==-1){    
	        $.each(datas,function(i,v){     // 如果是选中则添加选中行的 id
	        	$.axAsync2("user/addRole",{"roleId":roleId,"userId":v.userId});
	        });
	    }else{
	        $.each(datas,function(i,v){        
	            $.axAsync2("user/delRole",{"roleId":roleId,"userId":v.userId});
	        });
	    }
	}
	//授角用户结束
});
