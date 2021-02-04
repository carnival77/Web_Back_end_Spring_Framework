<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>

<script type="text/javascript">
	function movieDelete(id,title){
		var result = confirm(title+"영화를 정말 삭제하시겠습니까?");
		if(result){
			location.href = "movieDelete.do?id="+id;
		}
		
// 		userDelete.do?id=${user.id}
	}
</script>
</head>
<body>
	<h2>영화 목록</h2>
	<table>
		<tr>
			<th>순서</th>
			<th>영화ID</th>
			<th>제목</th>
			<th>&nbsp;</th>
		</tr>
		<%--
			List<UserVO> users = (List)request.getAttribute("users");
			for(int i=0;i<users.size();i++){
				UserVO user = users.get(i);
			}
		 --%>
		<c:forEach var="movie" items="${movies}" varStatus="status">
			<tr>
				<!-- <td>${user.id}</td> -->
				<td>${status.count }</td>
				<td><a href="movieDetail.do?title=${movie.title}">
						${movie.title } </a></td>
				<td>${movie.genre }</td>
				<td><a href="#"
					onclick="movieDelete(${movie.id},'${movie.title }')">삭제</a></td>
				<%-- 				<td><a href="userDelete.do?id=${user.id }">삭제</a></td> --%>
			</tr>
		</c:forEach>
	</table>
</body>
</html>