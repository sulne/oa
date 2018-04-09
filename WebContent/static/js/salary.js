$(function() {
	$.loadTable("#tbSalary","sal/list","#SalaryToolbar","salId",[
			{field : 'salId',title : '薪水编号',sortable : true},
			{field : 'empId',title : '员工编号',sortable : true},
			{field : 'baseSalary',title : '基本工资'},
			{field : 'isFullTime',title : '是否全勤',sortable : true},
			{field : 'boardWage',title : '伙食费'},
			{field : 'ZJTS',title : '出勤天数'},
			{field : 'RGTS',title : '日工天数'},
			{field : 'rPriece',title : '日工价'},
			{field : 'overTime',title : '加班工时'},
			{field : 'overPriece',title : '加班工资'},
			{field : 'ageSalary',title : '工龄工资'},
			{field : 'additionAward',title : '岗位补贴'},
			{field : 'other',title : '其他薪金'},		
			{field : 'ykTax',title : '应扣税金'},	
			{field : 'taxRate',title : '税率'},	
			{field : 'realSalary',title : '实发工资'},	
			]
		);
	}
);
