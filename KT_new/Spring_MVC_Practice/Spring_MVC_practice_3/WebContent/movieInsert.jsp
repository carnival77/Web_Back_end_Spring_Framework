<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
</head>
<body>
	<h2>영화 등록</h2>
	<form method="post">
		<!-- 		<form method="post" action="userInsert.do"> -->
		<!-- 		<input type="hidden" name="cmd" value="userInsert"> -->
		<table>
			<tr>
				<th>제목 :</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>장르 :</th>
				<td><input type="text" name="genre"></td>
			</tr>
			<tr>
				<th>감독 :</th>
				<td><input type="text" name="director"></td>
			</tr>
			<tr>
				<th>러닝타임 :</th>
				<td><select name="runningtime">
						<c:forEach var="runningtime" items="${runningtimes}">
							<option value="${runningtime}">${runningtime}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>

			</tr>
		</table>
	</form>
</body>
</html>