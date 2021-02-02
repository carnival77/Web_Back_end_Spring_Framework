<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록</title>
</head>
<body>
	<h2>사용자 등록</h2>
	<form method="post">
		<table>
			<tr>
				<th>사용자ID :</th>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td><input type="text" name="name"></td>
			</tr>		
			<tr>
				<th>성별 :</th>
				<td>
					<input type="radio" name="gender" value="남">남
					<input type="radio" name="gender" value="여">여
				</td>
			</tr>		
			<tr>
				<th>주소 :</th>
				<td>
					<select name="city">
						<c:forEach var="city" items="${cities}">
							<option value="${city}">${city}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>