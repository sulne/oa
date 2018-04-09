$(function() {
	$.loadTable("#tbAttence","attence/list","#AttenceToolbar","aId",[
			{field : 'aId',title : '工号',sortable : true},
			{field : 'name',title : '姓名',sortable : true},
			{field : 'dept',title : '所属部门'},
			{field : 'aDate',title : '日期',sortable : true},
			{field : 'firstStart',title : '第一时段上班'},
			{field : 'firstEnd',title : '第一时段下班'},
			{field : 'secondStart',title : '第二时段上班'},
			{field : 'secondEnd',title : '第二时段下班'},
			{field : 'lateTime',title : '迟到时间(分钟)'},
			{field : 'earlyOffTime',title : '早退时间(分钟)'},
			{field : 'absence',title : '缺勤时间(分钟)'},
			{field : 'count',title : '合计(分钟)'},
			{field : 'remark',title : '备注'},		
			]
		);
	}
);
