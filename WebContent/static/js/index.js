$(function() {
	// 加载首页
	// $.loadContent("home");
	$.loadURL("home");
	console.log(1);
	console.log($._data($('.navbar').get(0)));
	console.log($._data($('.side-menu').get(0)));
	// 根据导航加载页面
	$(".navibar").click(function() {
		var url = $(this).attr('target');
		$(".navbar-nav .active").removeClass("active");
		$(this).parents(".menu").addClass("active");
		console.log(this);
		$(this).addClass("active").removeClass("active");;
		$.loadURL(url);
	});

	$("#login").click(function() {
		$.post("login", {"userId" : $("#userId").val()}, function(data) {
			$.shortTips(data, 1500);
			$("#userId").parent().html("<a>"+data+"，已登录</a>");
		});
	});
});
