<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup01Call</title>
</head>
<body>
	<div>
		<p>korName = <c:out value='${param.korName}'/></p>
		<p>engName = <c:out value='${param.engName}'/></p>
		<p>age = <c:out value='${param.age}'/></p>
		<p>height = <c:out value='${param.height}'/></p>
		<p>weight = <c:out value='${param.weight}'/></p>
	</div>
</body>
</html>