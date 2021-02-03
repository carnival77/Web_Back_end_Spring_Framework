<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="common.jsp" />
<script>
	//$(document).ready(function(){	
	$(function(){	
// 		$("p").click(function() {
// 			$(this).hide();
// 		});
		$(".text-center").click(function(){
			alert();
		});
		$('#myDiv').css("color","red");
		
		$("p").on({
			  mouseenter: function(){
			    $(this).css("background-color", "lightgray");
			  },
			  mouseleave: function(){
			    $(this).css("background-color", "lightblue");
			  },
			  click: function(){
			    $(this).css("background-color", "yellow");
			  }
		});
		$("button").click(function(){
			  $("#div1").fadeOut();
			  $("#div2").fadeOut("slow");
			  $("#div3").fadeOut(3000);
		});
	});
		
</script>
<body>
	<p>클릭하세요</p>
	<span class="text-center">스팬태그</span>
	<div id="myDiv">DIV태그</div>
	<button>버튼</button>
	<div id="div1">첫번째div</div>
	<div id="div2">두번째div</div>
	<div id="div3">세번째div</div>
</body>
</html>