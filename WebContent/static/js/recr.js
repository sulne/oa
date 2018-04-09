$(function() {
	$.loadTable("#tbRecr","recr/list","#recrToolbar","rId",[
			{field : 'checkbox',checkbox : true,},
			{field : 'rId',title : 'ID',sortable : true},
			{field : 'name',title : '姓名',sortable : true},
			{field : 'phone',title : '手机'},
			{field : 'email',title : '邮箱'},
			{field : 'sex',title : '性别'},
			{field : 'age',title : '年龄',sortable : true},
			{field : 'household',title : '户籍'},
			{field : 'height',title : '身高'},
			{field : 'degree',title : '学历'},
			{field : 'marriage',title : '婚姻'},
			{field : 'rId',title : '操作',align : 'center',valign : 'middle',
				formatter : function(value, row, index) {
					var rId = value;
					var result = "<span class='glyphicon glyphicon-edit view-perm' title="+rId+"></span>";
					result += "<span style='margin-left:5px;' class='glyphicon glyphicon-remove delete-perm' title="+rId+"></span>";
					return result;
				}
			},
		]
	);
});
