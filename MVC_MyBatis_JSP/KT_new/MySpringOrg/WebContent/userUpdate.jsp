<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자  정보 수정</title>
</head>
<body>
	<h2>사용자 정보 수정</h2>
	<form method="post" action="userUpdate.do">
		<table>
			<tr>
				<th>사용자ID :</th>
				<td>
					${map.user.userid}
					<input type="hidden" name="userid" value="${map.user.userid}">
				</td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td><input type="text" name="name" value="${map.user.name}"></td>
			</tr>		
			<tr>
				<th>성별 :</th>
				<td>
					<c:choose>
						<c:when test="${map.user.gender eq '남'}">
							<input type="radio" name="gender" value="남" checked>남
							<input type="radio" name="gender" value="여">여
						</c:when>
						<c:when test="${map.user.gender eq '여'}">
							<input type="radio" name="gender" value="남">남
							<input type="radio" name="gender" value="여" checked>여
						</c:when>
					</c:choose>
				</td>
			</tr>		
			<tr>
				<th>주소 :</th>
				<td>
					<select name="city">
						<c:forEach var="city" items="${map.cities}">
							<c:choose>
								<c:when test="${city eq map.user.city}">
									<option value="${city}" selected>${city}</option>
								</c:when>
								<c:otherwise>
									<option value="${city}">${city}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>