<%@page import="kr.or.ddit.board.model.PageVo"%>
<%@page import="kr.or.ddit.board.model.UserVo"%>
<%@page import="kr.or.ddit.board.model.PostVo"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>답글 등록</title>

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />

<!-- jQuery -->
<!-- <script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->

<!-- <script type="text/javascript" src="/js/jquery/jquery-3.2.1.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<script src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});
	
	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	})
	
	//파일등록
	$("#addFile").on("click", function() {
		var fileLength = $(".filelable").length;
		
		if($(".myfiles").length + fileLength > 4) {
			alert("첨부파일은 최대 5개 입니다.");
			return;
		}
		newfile = $("<input/>", {"type" : "file", "class" : "myfiles", "name" : "myfile"});
		$(this).parent().append(newfile);
	});

	//파일삭제
	$(".deleteBtn").on("click", function() {
		
		var fileid = $(this).parent().find("input").val();
		var newHidden = $("<input/>", {"type" : "hidden", "name" : "file_id", "value" : fileid});
		$("#frm").append(newHidden);
		
		$(this).parent().remove();
	});
	
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

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
                  <h2 class="sub-header">게시글 등록</h2>  post_id :  ${postVo.post_id } board_id : ${board_id }
                  <form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/rePost" method="post" enctype="multipart/form-data">
					<input type="hidden" class="form-control" id="board_id" name="board_id"  value="${board_id}">				  			
					<input type="hidden" class="form-control" id="postuse_yn" name="postuse_yn"  value="1">				  			
					<input type="hidden" class="form-control" id="post_id" name="post_id"  value="${postVo.post_id }">				  			
					<input type="hidden" class="form-control" id="group_seq" name="group_seq"  value="${postVo.group_seq }">				  			
                     <div class="form-group">
                        <label for="title" class="col-sm-2 control-label" >제목</label>
                        <div class="col-sm-10">
                           <input type="text" class="form-control" id="title" name="title"  value="${postVo.title}">
                        </div>
                     </div>
                   
                   
                     <div class="form-group">
                        <label for="content" class="col-sm-2 control-label" >글내용</label>
                        <div class="col-sm-10">
                          <textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:455px; height:412px;"></textarea> 
                        </div>
                     </div>
      
      
      				<!-- ??????????????????? -->
      				
      				<div class="form-group">
                        <label for="attach" class="col-sm-2 control-label">첨부파일</label>
                        <div class="col-sm-10">
							<input type="file" name="attach" id="title" />
                        	<input type="button" id="addFile" value="추가" onclick="attach.add()">
                       
                       		 <c:forEach items="${attachList}" var="attachVO">
								<label class="filelable">${attachVO.attach_name} 
									<button type="button" class="deleteBtn">삭제</button>
									<input type="hidden" value="${attachVO.mattach_id}"/>
								</label>
								<br>
							</c:forEach>
							
							<input type="hidden" name="boardid" value="${board_id}"/>
							<input type="hidden" name="post_id" value="${post_id}"/>
							<input type="hidden" name="parent" value="${parent}"/>
                        </div>
                        
                     </div>
      
      
                     <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                           <button id="savebutton" type="submit" class="btn btn-default">사용자 등록</button>
                        	<input type="hidden" id="right" value="${right}"/>
                        </div>
                     </div>
      
                  </form>   

               </div>
            </div>
         </div>
      </div>
   </div>

</body>
</html>