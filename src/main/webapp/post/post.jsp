<%@page import="kr.or.ddit.board.model.PageVo"%>
<%@page import="kr.or.ddit.board.model.PostVo"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="kr.or.ddit.board.model.ReplyVo"%>
<%@page import="kr.or.ddit.board.model.AttachVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 날자 formet 변화 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<title>게시판 상세조회</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>

<script>

$(document).ready(function(){
	
	//수정
	$("#updateBtn").on("click", function() {
		$("#frm").attr("action", "${pageContext.request.contextPath}/postModify");
		$("#frm").attr("method", "get");
		$('#frm').submit();
	});
	
	//삭제
	$("#deleteBtn").on("click", function() {
// 		$("#frm").attr("action", "${pageContext.request.contextPath}/boardList?board_id="+board_id);
		$("#frm").attr("action", "${pageContext.request.contextPath}/deletePost?board_id="+$("#board_id").val());
		$("#frm").attr("method", "post");
		
		$('#frm').submit();
	});
	
	//답글
	$("#rePostBtn").on("click", function(){
		$("#frm").attr("action", "${pageContext.request.contextPath}/rePost");
		$("#frm").attr("method", "post");
	});
	
	//댓글삭제
	$("#removeReply").on("click", function(){
		$("#redelfrm").submit();
	});
	
});



</script>



</head>

<body>
   <!-- header -->
   <%@include file="/common/header.jsp"%>
   <div class="container-fluid">
      <div class="row">

         <!-- left -->
         <%@include file="/common/left.jsp"%>

         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
               <div class="col-sm-8 blog-main">
                  <h2 class="sub-header">게시판 상세</h2>
                  
                  <form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/postModify" method="post">
                           <input type="text" class="form-control" id="post_id" name="post_id"  value="${postVo.post_id }">
                           <input type="hidden" class="form-control" id="board_id" name="board_id"  value="${postVo.board_id }">
${postVo.post_id } 
                  
                     <div class="form-group">
                        <label for="postTitle" class="col-sm-2 control-label" >제목</label>
                        <div class="col-sm-10">
                           <label class="control-label">${postVo.title}</label>
                           
                        </div>
                     </div>
                     
      
                     <div class="form-group">
                        <label for="postContent" class="col-sm-2 control-label">글내용</label>
                        <div class="col-sm-10">
                           <label class="control-label">${postVo.content }</label>
                        </div>
                     </div>
                     

					<!-- 첨부파일 -->
					<div class="form-group">
                        <label for="attachid" class="col-sm-2 control-label">첨부파일</label>
                        <div class="col-sm-10">
<%--                            <img src="${pageContext.request.contextPath}/attachFile?filename=${attachVo.filename}" ></img> --%>
<!--                        		<input type="file" name="profile"/> -->
                       		<input type="text" name="profile" id="profile" value="${attachVo.filename }"/>
							
<%-- 						<c:forEach items="${attachList}" var="attach"> --%>
<%-- 							<span><a href="${attach.path}">${attach.filename}</a></span><br> --%>
<%-- 						</c:forEach> --%>
					
						<label class="control-label"></label>
						
						<button id="updateBtn" class="updateBtn" >수정</button>
						<button id="deleteBtn" class="deleteBtn" >삭제</button>
						
						<button id="rePostBtn" class="rePostBtn" >답글</button>
							
                        </div>
                     </div>
                     </form>
                    
                   
                     <!-- 댓글 -->
                     
                    <div class="form-group">
                    
                        <label for="replyid" class="col-sm-2 control-label">댓글</label><br>
 						<c:forEach items="${replyList }" var="replyVo" varStatus="status">
		                    <form id="redelfrm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/deleteReply" method="post">
		                      
		                      
		                       <input type="hidden" class="form-control" id="post_id" name="post_id" value="${replyVo.post_id }">
		                       <input type="hidden" class="form-control" id="reply_id" name="reply_id" value="${replyVo.reply_id }">
		                       <input type="hidden" class="form-control" id="reuse_yn" name="reuse_yn" value="${replyVo.reuse_yn }">
		                       <input type="hidden" class="form-control" id="board_id" name="board_id" value="${postVo.board_id }">
	                        	
		                      <table>
	                        
	                        	<c:choose>
	                        	<c:when test="${replyVo.reuse_yn == '1' }">
		                        	<tr>
		                        	<td class="control-label">${replyVo.reply_content }</td>
		                        	<td class="control-label">${replyVo.userid}</td>
		                        	<td class="control-label">${replyVo.reply_date }</td>
		                        	</tr>
	                        		<button id="removeReply" class="removeReply">댓글삭제</button>
		                        </c:when>
		                        	
	                        	<c:otherwise>
	                        	<tr>
	                        		<td>삭제된 댓글입니다</td>
	                        	</tr>
	                        		
	                        	</c:otherwise>
	                        	</c:choose>
	                        	
		                       </table>
	                        </form>
                        </c:forEach>   
                        
                        
                        <form id="refrm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/reply" method="post">
                        	<input type="text" class="form-control" id="reply_content" name="reply_content" value="${replyVo.reply_content }">
                        	<input type="hidden" class="form-control" id="userid" name="userid" value="${replyVo.userid }">
                        	<input type="hidden" class="form-control" id="reply_date" name="reply_date" value="${replyVo.reply_date }">
                        	<input type="hidden" class="form-control" id="post_id" name="post_id" value="${postVo.post_id}">
                        	<input type="hidden" class="form-control" id="board_id" name="board_id" value="${postVo.board_id}">
                            <button type="submit" class="btn btn-default" id="replyBtn">댓글저장</button>
						</form>                     
                        </div>
                     </div>
                     
               </div>
            </div>
         </div>
      </div>
   </div>
</body>
</html>






