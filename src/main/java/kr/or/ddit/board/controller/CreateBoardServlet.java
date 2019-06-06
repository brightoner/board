package kr.or.ddit.board.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.IUserService;
import kr.or.ddit.board.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(CreateBoardServlet.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/board/createBoard.jsp").forward(request, response);
		
		
	}

	//게시판 등록요청처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	
		
		String board_id = request.getParameter("board_id");
		String userid = request.getParameter("userId");
		String board_name = request.getParameter("createBoard");
		String use_yn = request.getParameter("combo");
		
		logger.debug("userid : {}",userid );
		logger.debug("board_name : {}", board_name);
		logger.debug("use_yn : {}", use_yn);
		
		BoardVo boardVo = null;
		
		boardVo = new BoardVo(userid, board_name, use_yn);
		logger.debug("boardVo : {}", boardVo );
		
		int insertCnt = boardService.insertBoard(boardVo);
		
		if(insertCnt == 1){
			request.getSession().setAttribute("boardVo", boardVo);
			response.sendRedirect(request.getContextPath()+"/createBoard");
			
			logger.debug("insertCnt : {}",insertCnt);
		}
	
			
		
	
		
	}

}
