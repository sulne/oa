$(function() {
	$.loadTable("#tbEmp","empl/list","#EmpToolbar","empId",[
			{field : 'checkbox',checkbox : true,},
			{field : 'empId',title : 'ID',sortable : true},
			{field : 'empName',title : '姓名',sortable : true},
			{field : 'sex',title : '性别'},
			{field : 'birthday',title : '生日',sortable : true},
			{field : 'email',title : '邮箱'},
			{field : 'mobile',title : '电话'},
			{field : 'idCard',title : '身份证'},
			{field : 'hireDate',title : '入职日期'},
			{field : 'empId',title : '操作',align : 'center',valign : 'middle',
				formatter : function(value, row, index) {
					var id = value;
					var result = "";
					result += "<span class='glyphicon glyphicon-edit view-emp-info' data-toggle='modal' data-target='#editEmpInfo' title=" + id + "></span>";
					return result;
				}
			},
		]
		
	);
	
	$(".refresh-emp-btn").click(function(){
		$("#tbEmp").bootstrapTable("refresh");
	});
	$(".search-emp-submit").click(function(){
		$("#tbEmp").bootstrapTable("refresh");
	});

	$(".add-emp-btn").click(function() {
		$("#addEmp").modal("show");
		$("#addEmp .add-submit").one("click",function(){
			$.axAsync("empl/add",$("#addEmpForm").serialize(),function(data){
				$("#addEmp").modal("hide");
				$.clearVal("#addEmp");
				$.showTips(data);
				$("#tbEmp").bootstrapTable("refresh");
			});
		});
	});
	
	$(".delete-checked-emp-btn").click(function() {
		var empArray = $("#tbEmp").bootstrapTable("getSelections");
		if(empArray < 1) {
			$.showTips("未选择数据")
		} else {
			$("#CheckedEmp").modal('show');
			var empIds=[];
        	for(var i=0;i<empArray.length;i++){
        		empIds[i]=empArray[i].empId;
        	}
        	$("#CheckedEmpSubmit").one('click',function(){
        		$("#CheckedEmp").modal('hide');
        		$.axAsyncList("empl/batchDelete",{"empIds":empIds},function(data){
        			$.showTips(data);
        			$("#tbEmp").bootstrapTable("refresh");
        		});
        	});
		}
	});
	
	$(".hide-checked-emp-btn").click(function() {
		var empArray = $("#tbEmp").bootstrapTable("getSelections");
		if(empArray < 1) {
			$.showTips("未选择数据")
		} else {
			$("#CheckedEmp").modal('show');
			var empIds=[];
        	for(var i=0;i<empArray.length;i++){
        		empIds[i]=empArray[i].empId;
        	}
        	$("#CheckedEmpSubmit").one('click',function(){
        		$("#CheckedEmp").modal('hide');
        		$.axAsyncList("empl/batchHide",{"empIds":empIds},function(data){
        			$.showTips(data);
        			$("#tbEmp").bootstrapTable("refresh");
        		});
        	});
		}
	});
	
	$("#tbEmp").on("click",".view-emp-info",function(){
		var empId = $(this).attr("title")
		$.axAsync("empl/view",{"empId":empId},function(emp) {
				$.clearVal("#viewEmp");
				$("#viewEmp input[name=empId]").attr("value", emp.empId);
				$("#viewEmp input[name=empName]").attr("value", emp.empName);
				$("#viewEmp input[name=sex]").attr("value", emp.sex);
				$("#viewEmp input[name=birthday]").attr("value", emp.birthday);
				$("#viewEmp input[name=email]").attr("value", emp.email);
				$("#viewEmp input[name=mobile]").attr("value", emp.mobile);
				$("#viewEmp input[name=idCard]").attr("value", emp.idCard);
				$("#viewEmp input[name=hireDate]").attr("value", emp.hireDate);
				$("#viewEmp").modal("show");
			}
		);
		$(".edit-emp-submit").one("click",function(){
			$.axAsync("empl/edit",$("#editEmpForm").serialize(),function(data){
				$("#viewEmp").modal("hide");
				$.showTips(data);
				$("#tbEmp").bootstrapTable("refresh");
			});
		});
	});
	
	//双日历控件
	$("#betweenDates").daterangepicker({
		"showDropdowns": true,
		"opens": "left",
		/* "timePicker": true,
		"timePicker24Hour": true, */
		"linkedCalendars" : true,
		"autoUpdateInput" : false,
		"locale" : {
		"format" : 'YYYY-MM-DD',
		/* "separator" : " ~ ", */
		"applyLabel" : "确定",
		"cancelLabel" : "取消",
		"fromLabel" : "起始时间",
		"toLabel" : "结束时间'",
		"customRangeLabel" : "自定义",
		"weekLabel" : "W",
		"daysOfWeek" : [ "日", "一", "二", "三", "四", "五", "六" ],
		"monthNames" : [ "一月", "二月", "三月", "四月", "五月","六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
		"firstDay" : 1
		},
		ranges : {
			'今日' : [ moment(), moment() ],
			'昨日' : [ moment().subtract(1, 'days'),moment().subtract(1, 'days') ],
			'最近7日' : [ moment().subtract(6, 'days'), moment() ],
			'最近30日' : [ moment().subtract(29, 'days'), moment() ],
			'本月' : [ moment().startOf('month'),moment().endOf('month') ],
			'上月' : [moment().subtract(1, 'month').startOf('month'),moment().subtract(1, 'month').endOf('month') ]
		},
		
	},
	function(start, end, label) {
	$("#dropdown-search-emp input[name=beginTime]").val(this.startDate.format(this.locale.format));
	$("#dropdown-search-emp input[name=endTime]").val(this.endDate.format(this.locale.format));
	});
	
	//单日历控件
	$('#birthdayDate').daterangepicker({
		"singleDatePicker": true,
		"showDropdowns" : true,
		"locale" : {
			"format" : 'YYYY-MM-DD',
        },
		"startDate" : moment(),
    });
});
