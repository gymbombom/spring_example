<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    
<html>
	<head>
		<meta charset="utf-8">
		<title>Ajax01</title>
		<script
  			src="https://code.jquery.com/jquery-3.6.0.js"
  			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  			crossorigin="anonymous">
		</script>
		
		<script>
			function fn_submit(){
				$.ajax({
					type :'POST',
					url  : "<c:url value='/ajax01Submit'/>",
					data :new FormData($("#ajaxVO")[0]),
					processData: false,
					contentType: false,
					dataType:"json",
					success:function(result){	
						if(result.success){
							alert("성공!!!!");
						}else{
							alert("실패!!!!");
						}
						

						alert("key :"+ result.key+"\n"+"value :"+result.value);

					},
					error:function(request,status,error){
						alert(error);
					}
				});	
			}
		</script>
	</head> 
	<body>
		<form id="ajaxVO" method="POST" enctype="multipart/form-data">
			<span>
				key :<input type="text" name="key"/>
			</span>
			<span>
				value : <input type="text" name="value"/>
			</span>
			<button onclick="fn_submit();">submit</button>
		</form>
	</body>
</html>
