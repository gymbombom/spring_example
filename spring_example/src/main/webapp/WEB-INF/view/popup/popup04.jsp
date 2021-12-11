<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Ajax01</title>
		<script
  			src="https://code.jquery.com/jquery-3.6.0.js"
  			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  			crossorigin="anonymous">
		</script>

		<script>
			var fnPopupCall = function(){
				var url = "/popup04Call";
				var name = "popup04";
				var option = "width=500, height=500, top=100, left=200, scrollbars=no, location=no, toolbars=no, status=no";
			
				window.open(url,name,option);
			}
		
			var fnPopupReturn = function(rt){
				alert(rt.korName);
			}
		</script>
	</head> 
	<body>
		<p>popup</p>
		<button onclick="fnPopupCall();">popup Call</button>
	</body>
</html>
