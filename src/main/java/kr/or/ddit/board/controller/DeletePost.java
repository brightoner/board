package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//게시글 삭제
//update문으로 사용유무만 정해준다
@WebServlet("/deletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(DeletePost.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		String post_id = request.getParameter("post_id");
//		
//		PostVo postVo = boardService.getPost(Integer.parseInt(post_id));
//		request.setAttribute("postVo", postVo);
		
		
		request.setAttribute("getUsPost", boardService.getUsePost());
		request.getRequestDispatcher("/post/postModify.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String board_id = request.getParameter("board_id");
		String post_id = request.getParameter("post_id");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		String postuse_yn = request.getParameter("postuse_yn");
		
		
		PostVo postVo = new PostVo();
		postVo.setPostuse_yn(postuse_yn);
		postVo.setPost_id(Integer.parseInt(post_id));
		
		int deleteCnt = boardService.deletePost(Integer.parseInt(post_id));
		
		logger.debug("deleteCnt : {1}",deleteCnt);
		
		if(deleteCnt == 1 ){
			
//			request.getSession().setAttribute("postVo", postVo);
//			List<PostVo> changePost = boardService.getUsePost();
//			request.getServletContext().setAttribute("postList", changePost);
//			getServletContext().setAttribute("postList", changePost);
//			request.getRequestDispatcher("/boardList").forward(request, response);
			
			response.sendRedirect(request.getContextPath()+"/boardList?board_id="+board_id);
			
		}
		
	}

}











