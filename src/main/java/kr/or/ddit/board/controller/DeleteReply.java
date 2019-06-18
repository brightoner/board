package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/deleteReply")
public class DeleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(DeleteReply.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String post_id = request.getParameter("post_id");
		request.setAttribute("post_id", post_id);
		String replyid = request.getParameter("replyid");
		request.setAttribute("replyid", replyid);
		
		request.setAttribute("getUseReply", boardService.getUseReply());
		request.getRequestDispatcher("/post/post.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String post_id = request.getParameter("post_id");
//		String reply_content = request.getParameter("reply_content");
		String board_id = request.getParameter("board_id");
		String reuse_yn = request.getParameter("reuse_yn");
		String reply_id = request.getParameter("reply_id");
		
		logger.debug("post_id :{}",post_id);
		logger.debug("board_id :{}",board_id);
		logger.debug("reuse_yn :{}",reuse_yn);
		logger.debug("reply_id :{}",reply_id);
		
		ReplyVo replyVo = new ReplyVo();
		
		logger.debug("replyVo :{}", replyVo);
		
		replyVo.setReuse_yn(reuse_yn);
		replyVo.setPost_id(Integer.parseInt(post_id));
		replyVo.setReply_id(Integer.parseInt(reply_id));
//		replyVo.setReply_content(reply_content);
		
		int deleteCnt = boardService.deleteRePost(Integer.parseInt(reply_id));
		
		logger.debug("deleteCnt : {}",deleteCnt);
		
		if(deleteCnt == 1){
									
			response.sendRedirect(request.getContextPath()+"/post?post_id="+post_id+"&board_id="+board_id);
		}
		
		
	}

}











