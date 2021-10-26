<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>

		<style>
			body {}
			.container { margin: 150px auto; }
		</style>
	</head>
	
	<!-- comboTree -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value='/js/comboTreePlugin.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/cTree.js'/>"  type="text/javascript"></script>
	<link rel="stylesheet" href="https://cdn.materialdesignicons.com/5.0.45/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>" >
	
	
	
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			
			//comboTree 초기데이터 생성
			initDataComboTree();
			
			//ComboTree Change 이벤트
	    	$('#justAnotherInputBox').change(function(){
	    		var splitResult = fnReturnComboTreeVal();
	    		
	    		//log
	    		console.log(splitResult.cateId);
	    		console.log(splitResult.eqId);
	    		console.log(splitResult.compoId);
	    	});
		});
		
		//ComboTree 초기데이터 생성
		var initDataComboTree = function(){
	        
			//Ajax로 DB에서 카테고리,기기,구성품 데이터 받아옴.
			$.ajax({
	            url: "<c:url value='/test02Submit'/>", 
	            type: "POST",
	            dataType : "json",
	            data: "",
	            success: function(data){
	            	
	            	var inputData = {
	            			cateList : data.cateList,
	            			eqList : data.eqList,
	            			compoList : data.compoList
	            	}
	            	
	               //comboTree 데이터 화면에 Render
	               gfnRenderComboTree("#justAnotherInputBox", inputData);
	            },
	            error: function(e){
	                alert("error");
	            }
	        });
		}

	</script>
	
	<body>
		<div class="container">
			<h1>ComboTree jQuery Plugin Demos</h1>
	
			<div>
				<a href="https://github.com/erhanfirat/combo-tree/">Github Home Page</a>
			</div>
	
			<div class="row">
				<div class="col-lg-6">
					<h3>Single Selection</h3>
					<input type="text" id="justAnotherInputBox" placeholder="Type to filter" autocomplete="off" />
				</div>
			</div>
		</div>
</body>
</html>
