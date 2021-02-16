<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기 화면</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function writeui(){
		location.href="write";
	}
	function noticeDelete(no,title){
// 		var result = title;
		if(no!=0){
			location.href = "noticeDelete.do?no="+no;
		}
	}
</script>
</head>
<body>
	<div class="container">
		<img src="image/ktds.png">
		<h2 class="text-center">공지사항 목록 화면</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${notices}" varStatus="status" >
					<tr>
						<!-- <td>${user.id}</td> -->
						<td>${notice.no }</td>
						<td><a href="retrieve?no=${notice.no}">
								${notice.title } </a></td>
						<td>${notice.author }</td>
						<td>${notice.writeday }</td>
						<td>${notice.readcnt }</td>
						<td><a href="#"
							onclick="noticeDelete(${notice.no},'${notice.title }')">삭제</a></td>
						<%-- 				<td><a href="userDelete.do?id=${user.id }">삭제</a></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button onclick="writeui()">글쓰기</button>
	</div>

</body>
</html>