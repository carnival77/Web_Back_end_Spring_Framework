<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 수정</title>
</head>
<body>
	<h2>영화 정보 수정</h2>
	<form method="post" action="movieUpdate.do">
		<!-- 		<form method="post" action="userInsert.do"> -->
		<!-- 		<input type="hidden" name="cmd" value="userInsert"> -->
		<table>
			<tr>
				<th>제목 :</th>
				<td><input type="text" name="genre" value="${map.movie.genre}"></td>
			</tr>
			<tr>
				<th>장르 :</th>
				<td><input type="text" name="genre" value="${map.movie.genre}"></td>
			</tr>
			<tr>
				<th>감독 :</th>
				<td><input type="text" name="director"
					value="${map.movie.director}"></td>
			</tr>
			<tr>
				<th>상영시간 :</th>
				<td><input type="text" name="runningtime"
					value="${map.movie.runningtime}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"></td>

			</tr>
		</table>
	</form>
</body>
</html>