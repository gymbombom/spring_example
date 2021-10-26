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
			
		 	var jsonArray = [];	
			
	        var form = {
	                korName: "홍길동",
	                engName: "Hong gil-dong",
	                age: 20,
	                height : "180.2",
	                weight : 68.3
	        }
	        jsonArray.push(form);
	        
	        form = {
	        	 korName: "김철수",
	             engName: "kim cheol-soo",
	             age: 20,
	             height : "180.2",
	             weight : 68.3
	        }
	        jsonArray.push(form);
	        
			$.ajax({
				  url : "<c:url value='/ajax06Submit'/>"
				, data : JSON.stringify(jsonArray)
				, type : "POST"
				, contentType: "application/json; charset=utf-8;"
				, dataType : "json"
				, traditional: true
				, async	: true
				, success : function(data) {
					console.log(data);
					alert(data.weight);
				}
				, error : function(res) {
					alert("에러가 발생하였습니다.");
					return false;
				}
			});			
		}
	</script>
	<body>
		<p>JsonArray 를 controller에서 처히방</p>
		<button onclick="submit();">submit</button>
	</body>
</html>
