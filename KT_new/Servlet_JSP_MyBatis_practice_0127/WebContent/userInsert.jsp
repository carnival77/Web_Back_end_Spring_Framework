<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록</title>
</head>
<body>
	<h2>사용자 등록</h2>
	<form method="post" action="userInsert.do">
		<input type="hidden" name="page" value="userInsert">
		<table>
			<tr>
				<th>ID :</th>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>성별 :</th>
				<td><input type="radio" name="gender" value="남">남 <input
					type="radio" name="gender" value="여">여</td>
			</tr>
			<tr>
				<th>주소 :</th>
				<td><select name="city">
						<option value="서울">서울</option>
						<option value="경기">경기</option>
						<option value="강원도">강원도</option>
				</select></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="등록">
				</td>
			</tr>
		</table>

	</form>

	<hr>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</body>
</html>