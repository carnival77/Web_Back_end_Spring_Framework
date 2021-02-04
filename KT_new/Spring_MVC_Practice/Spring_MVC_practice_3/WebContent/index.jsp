<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리 프로그램</title>
</head>
<body>
	<h1>영화 관리</h1>
	<%--
	 --%>
	<ul>
		<li><a href="movieList.do">1.영화 리스트</a></li>
		<li><a href="movieInsert.do">2.영화 등록</a></li>
	</ul>


	<!--
	<h1>Hello JSP</h1>
	<%-- 
	Date date = new Date();
	out.println("스트림으로 출력한 현재 시간은 " + date);
	--%>
	<h3>현재 시간은 : <%--=date --%>  </h3>
	-->

</body>
</html>