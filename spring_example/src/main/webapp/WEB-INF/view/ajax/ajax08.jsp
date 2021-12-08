<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Ajax08</title>
	</head> 
	<script
	  	src="https://code.jquery.com/jquery-3.6.0.js"
	  	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	  	crossorigin="anonymous">
	</script>
		
	<script>
		var submit = function(){
			
			//form을 JSONObject로 변경
			var formSerialize = $("#form").serializeObject();
			
			var subAjaxVO = {
	                korName: "서브VO",
	                engName: "subFAjaxVO",
	                age: 21,
	                height : "180.2",
	                weight : 68.3					
			}
						
 			formSerialize.subAjaxVO = subAjaxVO;
			
			console.log(formSerialize);
			
		
	        
			$.ajax({
				  url : "<c:url value='/ajax08Submit'/>"
				, data : JSON.stringify(formSerialize)
				, type : "POST"
				, contentType: "application/json; charset=utf-8;"
				, dataType : "json"
				, traditional: true
				, async	: true
				, success : function(data) {
					console.log(data);
					alert(data.subAjaxVO.korName);
				}
				, error : function(res) {
					alert("에러가 발생하였습니다.");
					return false;
				}
			});			
		}
		
		// form => JSON Object 로 변경
		$.fn.serializeObject = function()
		{
		   var o = {};
		   var a = this.serializeArray();
		   $.each(a, function() {
		       if (o[this.name]) {
		           if (!o[this.name].push) {
		               o[this.name] = [o[this.name]];
		           }
		           o[this.name].push(this.value || '');
		       } else {
		           o[this.name] = this.value || '';
		       }
		   });
		   return o;
		};
		
	</script>
	<body>
		<p>form을 JSONObject 로 변경하여 전송 => VO(model) 으로 받음.</p>
		<form id="form" name="form">
			한글이름: <input type="text" name="korName" value="홍길동">
			영문이름: <input type="text" name="engName" value="Hong Kil Dong">
			나이: <input type="number" name="age" value=20>
			키: <input type="text" name="height" value="180.2">
			몸무게: <input type="number" name="weight" value=68.3>
		</form>
		<button onclick="submit();">submit</button>
	</body>
</html>
