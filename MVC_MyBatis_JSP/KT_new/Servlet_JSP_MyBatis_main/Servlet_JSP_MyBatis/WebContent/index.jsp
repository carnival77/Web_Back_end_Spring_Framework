<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 관리</h1>
	<%--
	 --%>
	<ul>
		<li><a href = "userList.do?cmd=userList">1.사용자 리스트</a></li>
		<li><a href = "userInsert.do?cmd=userInsertForm">2.사용자 등록</a></li>
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