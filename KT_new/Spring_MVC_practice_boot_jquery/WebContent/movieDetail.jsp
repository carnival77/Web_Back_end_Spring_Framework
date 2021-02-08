<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세</title>
</head>
<body>
	<h2>영화 상세정보</h2>
	<table>
		<tr>
			<th>제목 :</th>
			<td>${movieOne.title}</td>
		</tr>
		<tr>
			<th>장르 :</th>
			<td>${movieOne.genre}</td>
		</tr>
		<tr>
			<th>감독 :</th>
			<td>${movieOne.director}</td>
		</tr>
		<tr>
			<th>상영시간 :</th>
			<td>${movieOne.runningtime}</td>
		</tr>
		<tr>
			<th>개봉일 :</th>
			<td><fmt:formatDate value="${movieOne.opendate }"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</table>
	<hr>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
	<a
		href="${pageContext.request.contextPath}/movieUpdate.do?title=${movieOne.title}">수정</a>
</body>
</html>