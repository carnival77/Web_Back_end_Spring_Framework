<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="common.jsp" />
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>사용자 목록</title> -->

<script type="text/javascript">
	function userDelete(id,userid){
		var result = confirm(userid+"사용자를 정말 삭제하시겠습니까?");
		if(result){
			location.href = "userDelete.do/"+id;
		}
		
// 		userDelete.do?id=${user.id}
	}
</script>
<!-- </head> -->
<body>
	<div class=" text-center">
		<h2>사용자 목록</h2>
	</div>
	<div class="container">
		<table class="table table-striped">

			<tr>
				<th>순서</th>
				<th>사용자ID</th>
				<th>이름</th>
				<th>성별</th>
				<th>주소</th>
			</tr>
			<%--
			List<UserVO> users = (List)request.getAttribute("users");
			for(int i=0;i<users.size();i++){
				UserVO user = users.get(i);
			}
		 --%>
			<c:forEach var="user" items="${users}" varStatus="status">
				<tr>
					<!-- <td>${user.id}</td> -->
					<td>${status.count }</td>
					<td><a href="userDetail.do?userid=${user.userid}">
							${user.userid } </a></td>
					<td>${user.name }</td>
					<td><a href="#"
						onclick="userDelete(${user.id},'${user.userid }')">삭제</a></td>
					<%-- 				<td><a href="userDelete.do?id=${user.id }">삭제</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		<!-- 	</div> -->
	</div>
</body>
</html>