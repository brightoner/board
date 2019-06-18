package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//댓글(저장)쓰기
@WebServlet("/reply")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(ReplyController.class);

	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String post_id = request.getParameter("post_id");
		String board_id = request.getParameter("board_id");
		request.setAttribute("post_id", post_id);
		request.setAttribute("board_id", board_id);
		
		request.getRequestDispatcher("/post/post.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");

		// String reply_id = request.getParameter("reply_id");
		String post_id = request.getParameter("post_id");
		String reply_content = request.getParameter("reply_content");
		String board_id = request.getParameter("board_id");
		
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		String userid = userVo.getUserid();
	
		logger.debug("post_id :{}", post_id);
		logger.debug("reply_content :{}", reply_content);
		logger.debug("userid :{}", userid);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_id(Integer.parseInt(board_id));
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setPost_id(Integer.parseInt(post_id));
		replyVo.setReply_content(reply_content);
		replyVo.setUserid(userid);
		
		

		logger.debug("replyVo : {}",replyVo);
		
		int insertCnt = boardService.insertReply(replyVo);

		logger.debug("insertCnt : {}", insertCnt);

		if (insertCnt == 1) {

			request.getSession().setAttribute("replyVo", replyVo);
			List<ReplyVo> newReplyList = boardService.getReply(Integer.parseInt(post_id));
			getServletContext().setAttribute("replyList", newReplyList);
			response.sendRedirect(request.getContextPath() + "/post?post_id="+Integer.parseInt(post_id)+"&board_id="+Integer.parseInt(board_id));
		
			
		}
		

	}

}
