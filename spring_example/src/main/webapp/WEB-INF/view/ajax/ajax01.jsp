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
						console.log(result);
						alert(result.korName);
					},
					error:function(request,status,error){
						alert(error);
					}
				});	
			}
		</script>
	</head> 
	<body>
		<form id="ajaxVO" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
			한글이름: <input type="text" name="korName" value="홍길동">
			영문이름: <input type="text" name="engName" value="Hong Kil Dong">
			나이: <input type="number" name="age" value=20>
			키: <input type="text" name="height" value="180.2">
			몸무게: <input type="number" name="weight" value=68.3>
			<button onclick="fn_submit();">submit</button>
		</form>
	</body>
</html>
