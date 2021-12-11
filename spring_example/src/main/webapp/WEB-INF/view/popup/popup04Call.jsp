<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup03Call</title>

		<script
  			src="https://code.jquery.com/jquery-3.6.0.js"
  			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  			crossorigin="anonymous">
		</script>

<script>
	var fnPopupReturn = function(){
		var korName = $("#korName").val();
		var engName = $("#engName").val();
		var age = $("#age").val();
		var height = $("#height").val();
		var weight = $("#weight").val();
		
		var rt = {
			korName : korName ,
			engName : engName,
			age : age,
			height : height,
			weight : weight
		}
		
		window.opener.fnPopupReturn(rt);
		window.close();
	}
</script>

</head>
<body>

	<div>
			한글이름: <input type="text" id="korName" name="korName" value="홍길동">
			영문이름: <input type="text" id="engName" name="engName" value="Hong Kil Dong">
			나이: <input type="number" id="age" name="age" value=20>
			키: <input type="text" id="height" name="height" value="180.2">
			몸무게: <input type="number" id="weight" name="weight" value=68.3>
			<button onclick="fnPopupReturn();">popup Call</button>
	</div>
</body>
</html>