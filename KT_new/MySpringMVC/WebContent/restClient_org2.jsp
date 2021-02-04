<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="common.jsp" />
<script>
$(function(){
	user_list();
	
	user_delete();
	
	user_insert();
	
	user_select();
	
	user_update();
	
	form_init();
	
	city_list();
});

function city_list() {
	$.ajax({
		url:'cities',
		method:'GET',
		error:function(error,status,msg) {
			alert("상태코드 : " + status + " 에러 메시지 : " + msg);
		},
		success: function(xhr){
			$.each(xhr, function(idx,city){
				$('<option>')
				.text(city)
				.val(city)
				//.attr('value',city)
				.appendTo('#citySelect');
			});
		}
	});
}

function form_init() {
	$('#btnInit').on('click',function(){
		$('#user_form').each(function(){
			this.reset();
		});
	});
}

function user_update() {
	$('#btnUpdate').on('click',function(){
		var userid = $("input:text[name='userid']").val();
		var name = $("input:text[name='name']").val();
		var gender = $("input:radio[name='gender']:checked").val();
		var city = $("select[name='city']").val();
		var userObj = {
				userid:userid,
				name:name,
				gender:gender,
				city:city
		};
		var userJson = JSON.stringify(userObj);
		$.ajax({
			url:'users',
			method:'PUT',
			data:userJson,
			contentType:'application/json',
			error:function(error,status,msg) {
				alert("상태코드 : " + status + " 에러 메시지 : " + msg);
			},
			success:function(xhr){
				console.log(xhr);
				if(xhr == 1) {
					$('#btnInit').trigger('click');
					user_list();
				}
			}
		});	
	});
}

function user_select() {
	$('body').on('click','#btnSelect',function(){
		var userid = $(this).closest('tr').find('#hidden_userid').val();
		//console.log(userid);
		$.ajax({
			url:'users/'+userid,
			method:'GET',
			error:function(error,status,msg) {
				alert("상태코드 : " + status + " 에러 메시지 : " + msg);
			},
			success:user_select_result
		});
	});
}

function user_select_result(xhr){
	var user = xhr;
	$('input:text[name="userid"]').val(user.userid);
	$('input:text[name="name"]').val(user.name);
	$('input:radio[name="gender"][value="'+user.gender+'"]').prop('checked',true);
	$('select[name="city"]').val(user.city).attr("selected","selected");
}

function user_insert() {
	$('#btnInsert').on('click',function(){
		var userid = $("input:text[name='userid']").val();
		var name = $("input:text[name='name']").val();
		var gender = $("input:radio[name='gender']:checked").val();
		var city = $("select[name='city']").val();
		var userObj = {
				userid:userid,
				name:name,
				gender:gender,
				city:city
		};
		var userJson = JSON.stringify(userObj);
		$.ajax({
			url:'users',
			method:'POST',
			data:userJson,
			contentType:'application/json',
			error:function(error,status,msg) {
				alert("상태코드 : " + status + " 에러 메시지 : " + msg);
			},
			success:function(xhr){
				console.log(xhr);
				if(xhr == 1) {
					$('#btnInit').trigger('click');
					user_list();
				}
			}
		});		
	});
}

function user_delete() {
	$('body').on('click','#btnDelete',function(){
		var id = $(this).closest('tr').find('#hidden_id').val();
		var userid = $(this).closest('tr').find('#hidden_userid').val();
		var result = confirm(userid + "님을 정말 삭제하시겠습니까?");
		console.log(result);
		if(result) {
			$.ajax({
				url:'users/'+id,
				method:'DELETE',
				error:function(error,status,msg) {
					alert("상태코드 : " + status + " 에러 메시지 : " + msg);
				},
				success:function(){
					user_list();
				}
			});
		}
	});
}

function user_list() {
	$.ajax({
		url:'users',
		method:'GET',
		contentType:'application/json;charset=utf-8',
		dataType:'json',
		error:function(error,status,msg) {
			alert("상태코드 : " + status + " 에러 메시지 : " + msg);
		},
		success:user_list_result		
	});
}
function user_list_result(xhr) {
	//console.log(xhr);
	$('tbody#list').empty();
	$.each(xhr, function(idx,user){
		//console.log(idx, user);
		$("<tr>")
			.append($("<td>").html(idx+1))
			.append($("<td>").html(user.userid))
			.append($("<td>").html(user.name))
			.append($("<td>").html(user.gender))
			.append($("<td>").html(user.city))
			.append($("<td>").html("<button class='btn btn-success' id='btnSelect'>조회</button>"))
			.append($("<td>").html("<button class='btn btn-danger' id='btnDelete'>삭제</button>"))
			.append($("<input type='hidden' id='hidden_id'>").val(user.id))
			.append($("<input type='hidden' id='hidden_userid'>").val(user.userid))
			.appendTo('tbody#list');
	});//each
}

</script>

<body>
	<div class="text-center">
		<h2>사용자 등록</h2>
	</div>
	
	<div class="container p-3">
	<form id="user_form" method="post">
		<table>
			<tr class="form-group">
				<th>사용자ID :</th>
				<td><input class="form-control" type="text" name="userid"></td>
			</tr>
			<tr class="form-group">
				<th>이름 :</th>
				<td><input class="form-control" type="text" name="name"></td>
			</tr>		
			<tr class="form-group">
				<th>성별 :</th>
				<td>
					<div class="form-control">
					<input type="radio" name="gender" value="남">남
					<input type="radio" name="gender" value="여">여
					</div>
				</td>
			</tr>		
			<tr class="form-group">
				<th>주소 :</th>
				<td>
					<select class="form-control" id="citySelect" name="city">
					</select>
				</td>
			</tr>
		</table>
		<div class="container p-3">
			<div class="btn-group">
				<input type="button" id="btnInsert" value="등록" class="btn btn-primary">
				<input type="button" id="btnUpdate" value="수정" class="btn btn-secondary">
				<input type="button" id="btnInit" value="초기화" class="btn btn-info">
			</div>
		</div>		
		
	</form>
	</div>
	<hr>
	<div class="text-center">
		<h2>사용자 목록 Ajax</h2>
	</div>
	<div class="container p-3">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>순서</th>
				<th>사용자ID</th>
				<th>이름</th>
				<th>성별</th>
				<th>주소</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody id='list'></tbody>
	</table>
	</div>	
</body>
</html>