<%@page import="kr.or.ddit.board.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JSP/SPRING header.jsp
			
			<% UserVo SESSION_USER = (UserVo)session.getAttribute("USER_INFO");
				String userName = "";
				if(SESSION_USER ==null)
					userName ="접속전입니다";
				else
					userName = SESSION_USER.getName();
			
			%>
			<%=userName %>
			

		</div>
		<div id="navbar" class="navbar-collapse collapse" >
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>