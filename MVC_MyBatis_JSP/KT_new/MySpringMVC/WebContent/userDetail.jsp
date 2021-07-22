<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세</title>
</head>
<body>
	<h2>사용자 상세정보</h2>
	<table>
		<tr>
			<th>사용자ID :</th>
			<td>${userOne.userid}</td>
		</tr>
		<tr>
			<th>이름 :</th>
			<td>${userOne.name}</td>
		</tr>
		<tr>
			<th>성별 :</th>
			<td>${userOne.gender}</td>
		</tr>
		<tr>
			<th>주소 :</th>
			<td>${userOne.city}</td>
		</tr>
		<tr>
			<th>가입일자 :</th>
			<td><fmt:formatDate value="${userOne.regdate }"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</table>
	<hr>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
	<a
		href="${pageContext.request.contextPath}/userUpdate.do?userid=${userOne.userid}">수정</a>
</body>
</html>