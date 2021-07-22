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
		<c:forEach var="user" items="${users }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user.userid }</td>
				<td><a
					href="userDetail.do?page=userDetail&username=${user.name}"}">${user.name }</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>