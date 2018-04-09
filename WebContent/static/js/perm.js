$(function() {
	$.loadTable("#tbPerm","perm/list","#permToolbar","permissionId",[
			{field : 'checkbox',checkbox : true,},
			{field : 'permissionId',title : 'ID',sortable : true},
			{field : 'permissionDesc',title : '权限描述',sortable : true},
			{field : 'url',title : 'url'},
			{field : 'isNavigation',title : '导航'},
			{field : 'permissionCode',title : '代码'},
			{field : 'permissionId',title : '操作',align : 'center',valign : 'middle',
				formatter : function(value, row, index) {
					var permId = value;
					var result = "<span class='glyphicon glyphicon-edit view-perm' title="+permId+"></span>";
					result += "<a style='margin-left:5px;' class='glyphicon glyphicon-wrench set-role' title='授予角色' target="+permId+"></a>";
					result += "<span style='margin-left:5px;' class='glyphicon glyphicon-remove delete-perm' title="+permId+"></span>";
					return result;
				}
			},
		]
	);
	
	$(".add-perm-btn").click(function() {
		$("#addPerm").modal("show");
		$("#addPerm .add-perm-submit").one("click",function(){
			$.axAsync("perm/add",$("#addPermForm").serialize(),function(data){
				$("#addPerm").modal("hide");
				$.showTips(data);
				$("#tbPerm").bootstrapTable("refresh");
			});
		});
	});
	
	$(".delete-checked-perm-btn").click(function() {
		var permArray = $("#tbPerm").bootstrapTable("getSelections");
		if(permArray < 1) {
			$.showTips("未选择数据")
		} else {
			$("#CheckedPermTips").modal('show');
			var permIds=[];
        	for(var i=0;i<permArray.length;i++){
        		permIds[i]=permArray[i].permissionId;
        	}
        	$("#CheckedPermSubmit").one('click',function(){
        		$("#CheckedPermTips").modal('hide');
        		$.axAsyncList("perm/batchDelete",{"permIds":permIds},function(data){
        			$.showTips(data);
        			$("#tbPerm").bootstrapTable("refresh");
        		});
        	});
		}
	});
	
	$("#tbPerm").on("click",".view-perm",function(){
		var permId = $(this).attr("title");
		$.axAsyncList("perm/view",{"permId":permId},function(perm) {
		
			$("#viewPerm input[name=permissionId]").attr("value", perm.permissionId);
			$("#viewPerm input[name=permissionDesc]").attr("value", perm.permissionDesc);
			$("#viewPerm input[name=url]").attr("value", perm.url);
			$("#viewPerm input[name=isNavigation]").attr("value", perm.isNavigation);
			$("#viewPerm input[name=permissionCode]").attr("value", perm.permissionCode);
			}
		);
		$("#viewPerm").modal("show");
		$(".edit-perm-submit").one("click",function(){
			$.axAsync("perm/edit",$("#editPermForm").serialize(),function(data){
				$("#viewPerm").modal("hide");
				$.showTips(data);
				$("#tbPerm").bootstrapTable("refresh");
			});
		});
	});
	
	$("#tbPerm").on("click",".delete-perm",function(){
		var permId = $(this).attr("title");
		$.axAsync2("perm/delete",{"permId":permId});
		$("#tbPerm").bootstrapTable("refresh");
	});
	
	//授权角色
	$("#tbPerm").on("click",".set-role",function(){
		var permId = $(this).attr("target");
		$("#showPermRole .permId").html(permId);
		$("#showPermRole").modal("show");
		$("#tbPermRole").bootstrapTable("destroy");
		$.loadTable2("#tbPermRole","role/getPermRole","#PermRoleToolbar","roleId",
				[
					{field : 'checkbox',checkbox :true,formatter : function(value, row, index){
						if(permId == row.rolePerm.permissionId) {
							return {
								checked:true,
							};
						}
						return value;
					}},
					{field: 'roleId',title: 'ID',sortable : true},
					{field: 'roleName',title: '角色名'},
					{field: 'roleDesc',title: '角色描述'},
					{field: 'roleCode',title: '角色代码'},
				],
				function(params) {
					var limit = {   
							limit: params.limit,                         
							offset: params.offset, 
							search: params.search, 
							sort: params.sort,      
							order: params.order,
							permId: permId,
	                    };
					return limit;
				}
			
		);
	});
	
	$('#tbPermRole').on('uncheck.bs.table check.bs.table check-all.bs.table uncheck-all.bs.table',function(e,rows){
        var datas = $.isArray(rows) ? rows : [rows];        // 点击时获取选中的行或取消选中的行
        examine(e.type,datas);
	});
	
	function examine(type,datas){           // 操作类型，选中的行
		var permissionId = $("#showPermRole .permId").html();
	    if(type.indexOf('uncheck')==-1){    
	        $.each(datas,function(i,v){     // 如果是选中则添加选中行的 id
	        	$.axAsync2("role/addPerm",{"roleId":v.roleId,"permissionId":permissionId});
	        });
	    }else{
	        $.each(datas,function(i,v){        
	            $.axAsync2("role/delPerm",{"roleId":v.roleId,"permissionId":permissionId});
	        });
	    }
	}
	//授权角色结束
});
