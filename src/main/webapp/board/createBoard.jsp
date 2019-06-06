<%@page import="kr.or.ddit.board.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>

<script>
$(document).ready(function(){
	$("#createBtn").on("click", function(){
		$("#createfrm").submit();
	});
	
});


</script>


</head>

<body>

	<!-- header -->
	<%@include file="/common/header.jsp" %>
	
<div class="container-fluid">
		<div class="row">
		
		<!-- left -->
		<%@include file="/common/left.jsp" %>
			
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				



<div class="row">

	<div class="col-sm-8 blog-main">

		<form action="${pageContext.request.contextPath }/createBoard" id="createfrm"  method="post">
		게시판이름 :
		<input type="text" name="createBoard" id="createBoard" class="createBoard" >
		<input type="hidden" id="userId" name="userId" value="${USER_INFO.userid }"/>
		<select name="combo" form="createfrm">
			<option value="1">사용</option>
			<option value="2">미사용</option>
		</select>
		<button id="createBtn" type="submit" >생성</button>
		<br><br>
	
		<c:forEach items="${boardList }" var="vo" varStatus="status">
			게시판이름 :
			<input type="text" name="createBoard" id="createBoard" class="createBoard" value="${vo.board_name }">
			<select name="combo" form="createfrm">
				<option value="1">사용</option>
				<option value="2">미사용</option>
			</select>
			<button class="createBtn" type="submit" >수정</button>
			<br><br>
		</c:forEach>
	
	</form>
	
	</div>
	<!-- /.blog-main -->
</div>	</div>
		</div>
	</div>
</body>
</html>
    