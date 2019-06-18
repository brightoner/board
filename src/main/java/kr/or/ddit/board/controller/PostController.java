package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.util.PartUtil;

//게시글 상세보기

@WebServlet("/post")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(PostController.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
   //새글 등록화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		String post_id = request.getParameter("post_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String board_id = request.getParameter("board_id");
		
		PostVo postVo = boardService.getPost(Integer.parseInt(post_id));
		
		List<ReplyVo> replyList = boardService.getReply(Integer.parseInt(post_id));
		
		List<AttachVo> attachList = boardService.getAttach(Integer.parseInt(post_id));
		
		logger.debug("postVo:{}",postVo);
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		request.setAttribute("postVo", postVo);
//		String userid = userVo.getUserid();
//		logger.debug("userid:{}",userVo.getUserid());
//		request.setAttribute("userid", userid);
		
		request.setAttribute("board_id", board_id);
		request.setAttribute("replyList", replyList);
		request.setAttribute("attachList", attachList);
		
		request.getRequestDispatcher("/post/post.jsp").forward(request, response);
		
		
	}


	//사용자 등록 요청처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reply_content = request.getParameter("reply_content");
//		String userId = request.getParameter("userId");
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		String post_id = request.getParameter("post_id");
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setUserid(userVo.getUserid());
		replyVo.setReply_content(reply_content);
		replyVo.setPost_id(Integer.parseInt(post_id));
		int cnt = boardService.insertReply(replyVo);
		if(cnt==1){
			response.sendRedirect(request.getContextPath()+"/post?post_seq="+Integer.parseInt(post_id));
		}
	}

}
