<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>    
<!DOCTYPE html>
<html>
<%-- 
<%@ include file="common.jsp"%>
--%>
<jsp:include page="common.jsp" />


<!-- html 주석 -->
<%-- jsp 주석 --%>
<body>
	<div class="text-center">
		<h1>사용자 관리</h1>
	</div>
	<%-- 
	 Date date = new Date();
	 out.println("스트림으로 출력 현재 시간은 " + date);
	--%>
	<div class="container pt-3 p-3 my-3 bg-dark text-white">
		<ul>
			<li><a href="userList.do">1.사용자 리스트</a></li>
			<li><a href="userInsert.do">2.사용자 등록</a></li>
		</ul>
	</div>
</body>
</html>