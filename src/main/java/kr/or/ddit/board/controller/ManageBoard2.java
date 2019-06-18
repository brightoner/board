package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;


//게시판 사용유무
@WebServlet("/useBoard")
public class ManageBoard2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ManageBoard2.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("allboardList", boardService.allBoardList());
		request.getRequestDispatcher("/board/manageBoard.jsp").forward(request, response);
		
		
		
	}


	//게시판 사용유무 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String board_name = request.getParameter("changeBoard");
		String use_yn = request.getParameter("use_yn");
		String board_id = request.getParameter("board_id");
		
		logger.debug("board_name : {}",board_name);
		logger.debug("use_yn : {}",use_yn);
		logger.debug("board_id : {}",board_id);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_id(Integer.parseInt(board_id));
		boardVo.setUse_yn(use_yn);
		
//		List<BoardVo> boardList = boardService.allBoardList();
		
		int updateCnt = boardService.updateUseBoard(boardVo);
		
		logger.debug("updateCnt : {}",updateCnt);
		
		if(updateCnt == 1){
			
//			List<BoardVo> changeBoardList = boardService.useBoardList("1");
			List<BoardVo> changeBoardList = boardService.allBoardList();
			request.getServletContext().setAttribute("boardList", changeBoardList);
			request.setAttribute("allList", boardService.allBoardList());
			request.getRequestDispatcher("/board/manageBoard.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/manageBoard");
			
			
			
		}
		
	}

}
