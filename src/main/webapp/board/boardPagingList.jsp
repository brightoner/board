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

<title>${boardVo.board_name }</title>

<!-- scc, js -->
<%@include file="/common/basicLib.jsp" %>

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
						
<!-- 						사용자 상세 조회 : userId가 필요 -->
						<form id="frm" action="${pageContext.request.contextPath }/post" method="get">
							<input type="hidden" id="userId" name="userId"/>
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글번호</th>
									<th>제목</th>
									<th>작성자아이디</th>
									<th>작성일시</th>
								</tr>
								
								<c:forEach items="${postList }" var="vo" varStatus="status">
									<tr>
										<td>${vo.post_id }</td>
										<td>${vo.title}</td>
										<td>${vo.userid }</td>
										<td>${vo.reg_dt }</td>
									</tr>
								</c:forEach>
															
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<!-- 사용자 수 : 105건 // 페이지 네이션 : 11건 -->
						<div class="text-center">
							<ul class="pagination">
							
								<c:choose>
									<c:when test="${pageVo.page == 1 }">
										<li class="disabled"><span>«</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath }/boardPagingList?page=${pageVo.page -1 }&pageSize=${pageVo.pageSize }">«</a></li>
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
									 		<a href="${pageContext.request.contextPath}/boardPagingList?page=${i }&pageSize=${pageVo.pageSize }">${i }</a>
									 	<li>
									</c:otherwise>
								</c:choose>
								</c:forEach>
								
								<c:choose>
									<c:when test="${pageVo.page == paginationSize }">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/boardPagingList?page=${pageVo.page +1 }&pageSize=${pageVo.pageSize }">»</a></li>
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
