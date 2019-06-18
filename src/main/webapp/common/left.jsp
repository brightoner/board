<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="${pageContext.request.contextPath}/manageBoard">게시판 생성</a></li>
		
		<c:forEach items="${boardList }" var="vo" varStatus="status">
			<c:choose>
				<c:when test="${vo.use_yn eq '1' }">
					<li class="active"><a href="${pageContext.request.contextPath}/boardList?board_id=${vo.board_id}">${vo.board_name }</a></li>
				</c:when>
			</c:choose>
		</c:forEach>
	</ul>
</div>