<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			var html= "";
			
			var a = "aa";
			var b = "한글";
			var c = 1;
			var d = 1.00;
			var e = "1.000";
			
			html+= String.format("<p>{0}</p>",a);
			html+= String.format("<p>{0}</p>",b);
			html+= String.format("<p>{0}</p>",c);
			html+= String.format("<p>{0}</p>",d);
			html+= String.format("<p>{0}</p>",e);
			html+= String.format("<p>{0}{1}{2}{3}</p>",a,b,c,d);
			
			$("#test").append(html);
		});
		
		//format 문자열 함수
		String.format = function(formatted) {
		    var args = Array.prototype.slice.call(arguments, 1);
		    return formatted.replace(/{(\d+)}/g, function(match, number) { 
		        return typeof args[number] != 'undefined' ? args[number] : match;
		    });
		}
		
	</script>
	
	<body>
		<div class="container">
				<div id="test" class="col-lg-6">
				</div>
		</div>
</body>
</html>
