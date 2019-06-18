<%@page import="kr.or.ddit.board.model.PostVo"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
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

<%-- <title>${boardVo.board_name }</title> --%>
<title>${boardVo.board_id }</title>

<!-- scc, js -->
<%@include file="/common/basicLib.jsp" %>

<style>
	.boardTr:hover{
		cursor:pointer;
	}
</style>


<script>
$(document).ready(function(){
	
	$(".boardTr").on("click",function(){
		
		var postnum = $(this).find(".post").text();
		$("#post").val(postnum);
		
		$("#frm").submit();
		
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
						<h2 class="sub-header">${boardVo.board_name }</h2>
						
<!-- 						게시글 상세 조회 : userId가 필요 -->
						<form id="frm" action="${pageContext.request.contextPath }/post" method="get">
							<input type="hidden" id="post" name="post_id" value="${postVo.post_id }"/>
							<input type="hidden" id="board_id" name="board_id" value="${board_id }"/>
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글번호</th>
									<th>제목</th>
									<th>작성자아이디</th>
									<th>작성일시</th>
								</tr>
								
								<c:forEach items="${postList }" var="postList" varStatus="status">
									<c:choose>
										<c:when test="${postList.postuse_yn =='1' }">
											<tr class="boardTr" data-userid="${postList.userid }">
												<td class="post">${postList.post_id }</td>
												<td>
												
													<c:choose >
													<c:when test="${postList.lv > 0}">
														
												<c:forEach items="${postList.lv }">
														&nbsp;&nbsp;&nbsp;
												</c:forEach> re: ${postList.title}
													</c:when>
													<c:otherwise>
														${postList.title}
													</c:otherwise>
													</c:choose>
												
												</td>
												<td>${postList.userid }</td>
												<td>${postList.post_date }</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>삭제된게시물입니다</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:forEach>
															
							</table>
						</div>

						<a href="${pageContext.request.contextPath }/insertPost?board_id=${board_id}" class="btn btn-default pull-right">새글등록</a>
						<!-- 게시글 수 // 페이지 네이션 건 -->
						<div class="text-center">
							<ul class="pagination">
							
								<c:choose>
									<c:when test="${pageVo.page == 1 }">
										<li class="disabled"><span>«</span></li>
									</c:when>
									<c:otherwise>													
										<li><a href="${pageContext.request.contextPath }/boardList?board_id=${board_id }&page=${pageVo.page -1 }&pageSize=${pageVo.pageSize }">«</a></li>
									</c:otherwise>
								
								</c:choose>
								
								<c:forEach begin="1" end="${paginationSize }" step="1" var="i">
								<c:choose>
									<c:when test="${pageVo.page ==i }">
										<li class="active">
											<span>${i }</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
									 		<a href="${pageContext.request.contextPath}/boardList?board_id=${board_id }&page=${i }&pageSize=${pageVo.pageSize }">${i }</a>
									 	<li>
									</c:otherwise>
								</c:choose>
								</c:forEach>
								
								<c:choose>
									<c:when test="${pageVo.page == paginationSize }">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/boardList?board_id=${board_id }&page=${pageVo.page +1 }&pageSize=${pageVo.pageSize }">»</a></li>
									</c:otherwise>
								</c:choose>
							
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
