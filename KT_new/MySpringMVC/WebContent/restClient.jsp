<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="common.jsp" />

<script>
	$(function() {
		user_list();
	});

	function user_list() {
		$.ajax({
			url : 'users',
			method : 'GET',
			contentType : 'application/json;charset=utf-8',
			dataType : 'json',
			error : function(error, status, msg) {
				alert("상태코드 " + status + "error msg :" + msg);
			},
			success : user_list_result
		});
	}
	function user_list_result(xhr) {
		// 		console.log(xhr);
		$.each(xhr, function(idx, user) {
			console.log(idx, user.name);
			$("<tr>").append($("<td>").html(user.id)).append(
					$("<td>").html(user.userid)).append(
					$("<td>").html(user.name)).append(
					$("<td>").html(user.gender)).append(
					$("<td>").html(user.city)).append(
					$("<td>").html("<button class='btn-danger' id='btnDelete'>삭제</button>"))
					.appendTo('tbody');
		});
	}
</script>

<body>
	<div class=" text-center">
		<h2>사용자 목록 Ajax</h2>
	</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>순서</th>
					<th>사용자ID</th>
					<th>이름</th>
					<th>성별</th>
					<th>주소</th>
					<th>$</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>

	</div>
</body>
</html>