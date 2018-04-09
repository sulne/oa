<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 提示框 -->
<div class="modal fade" id="op-tips-dialog" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">提示信息</h4>
			</div>
			<div class="modal-body" id="op-tips-content"></div>
		</div>
	</div>
</div>

<div class="modal fade" id="shortTipsDialog" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm" role="document">
		<div class="panel panel-default">
			<div class="panel-heading">消息</div>
			<div class="panel-body short-tips-content"></div>
		</div>

	</div>
</div>