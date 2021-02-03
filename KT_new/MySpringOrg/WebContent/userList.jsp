<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<jsp:include page="common.jsp" />

<script type="text/javascript">
	function userDelete(id,userid) {
		var result = confirm(userid + " 사용자를 정말 삭제하시겠습니까?");
		if(result) {
			location.href="userDelete.do/" + id;
		}
	}
</script>
</head>
<body>
	<div class="text-center">
		<h2>사용자 목록</h2>
	</div>
	<div class="container p-3">
	<table class="table table-striped">
		<tr>
			<th>순서</th>
			<th>사용자ID</th>
			<th>이름</th>
			<th>&nbsp;</th>
		</tr>
		<%--
			List<UserVO> users = (List)request.getAttribute("users");
			for(int i=0;i<users.size();i++) {
			    UserVO user = users.get(i);
			}
		 --%>
		<c:forEach  var="user" items="${users}" varStatus="status">
			<tr>
				<td>${status.count}</td> <%--=user.getId() --%>
				<td>
					<a href="userDetail.do?userid=${user.userid}">
						${user.userid}
					</a>
				</td>
				<td>${user.name}</td>
				<td><a href="#" onclick="userDelete(${user.id},'${user.userid}')">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>