<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Ajax02</title>
	</head> 
	<script
	  	src="https://code.jquery.com/jquery-3.6.0.js"
	  	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	  	crossorigin="anonymous">
	</script>
		
	<script>
		var submit = function(){
	        var form = {
	                korName: "홍길동",
	                engName: "Hong gil-dong",
	                age: 20,
	                height : "180.2",
	                weight : 68.3
	        }
			
	        $.ajax({
	            url: "<c:url value='/ajax04Submit'/>", 
	            type: "POST",
	            dataType : "json",
	            data: form,
	            success: function(data){
	                console.log(data);
	            },
	            error: function(e){
	                alert("error");
	            }
	        });
	        
		}
	</script>
	<body>
		<p>Json 전송 => Controller에서 Map으로 받음</p>
		<button onclick="submit();">submit</button>
	</body>
</html>
