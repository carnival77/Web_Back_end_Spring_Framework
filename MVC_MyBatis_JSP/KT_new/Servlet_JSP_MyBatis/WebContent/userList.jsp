<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>
	<h2>사용자 목록</h2>
	<table>
		<tr>
			<th>순서</th>
			<th>사용자ID</th>
			<th>이름</th>
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
				<td>
					<a href="userDetail.do?cmd=userDetail&userid=${user.userid}">
						${user.userid }
					</a>
				</td>
				<td>${user.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>