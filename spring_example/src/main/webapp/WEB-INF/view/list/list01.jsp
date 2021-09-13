<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    
<html>
	<head>
		<!-- meta 정보가 있어야 Excel 한글 정상 출력 가능함  -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Ajax01</title>
		<script
  			src="https://code.jquery.com/jquery-3.6.0.js"
  			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  			crossorigin="anonymous">
		</script>
		
		<script>
		$(document).ready(function() {
			//UP 버튼 클릭
			$('#btnUp').click(function() {
				var current = $('.on');
				current.prev().before(current);
				fnSortRoleIndex(); //순서 재정렬
			});

			//Down 버튼 클릭
			$('#btnDown').click(function() {
				var current = $('.on');
				current.next().after(current);
				fnSortRoleIndex(); //순서 재정렬
			});
			
			$('#ulList>li').click(function() {
				$(".on").removeClass();
				$(this).addClass("on");
			});
		});
		
		
		function fnSortRoleIndex() {
			$("#ulList>li").each(function(index, element) {
				$(this).attr("data-roleIndex", index);
			});
		}
		</script>
		<style>
			.on {
				font-weight: bold;
				color: red;
			}
		</style>
		
	</head> 
	<body>
		<button id="btnUp">Up</button>
		<button id="btnDown">Down</button>
		<ul id="ulList">
			<li data-roleId="1" data-roleIndex="1">1</li>
			<li data-roleId="2" data-roleIndex="2">2</li>
			<li data-roleId="3" data-roleIndex="3">3</li>
			<li data-roleId="4" data-roleIndex="4">4</li>
			<li data-roleId="5" data-roleIndex="5">5</li>
		</ul>
	</body>
</html>
