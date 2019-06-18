package kr.or.ddit.board.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
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

//게시판 추가 
@WebServlet("/manageBoard")
public class ManageBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ManageBoardServlet.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("allboardList", boardService.allBoardList());
		request.getRequestDispatcher("/board/manageBoard.jsp").forward(request, response);
		
	}

	//게시판 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	
		
		//등록
		String board_name = request.getParameter("createBoard");
		String use_yn = request.getParameter("combo");
//		String board_id = request.getParameter("board_id");
//		String userid = request.getParameter("userId");
		
//		logger.debug("userid : {}",userid );
		logger.debug("board_name : {}", board_name);
		logger.debug("use_yn : {}", use_yn);
		
		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");
		
		BoardVo boardVo = new BoardVo();
		
//		boardVo.setBoard_id(Integer.parseInt(board_id));
		boardVo.setBoard_name(board_name);
		boardVo.setUserid(userVo.getUserid());
		boardVo.setUse_yn(use_yn);
		
//		BoardVo boardVo = null;
//		boardVo = new BoardVo(Integer.parseInt(board_id), board_name, use_yn);
		logger.debug("boardVo : {}", boardVo );
		
		List<BoardVo> boardList = boardService.allBoardList();
		for(BoardVo vo : boardList){
			if(vo.getBoard_name().equals(board_name)){
				doGet(request, response);
				return;
			}
		}
		
		int insertCnt = boardService.insertBoard(boardVo);
		
		if(insertCnt == 1){
			request.getSession().setAttribute("boardVo", boardVo);
			
//			List<BoardVo> newBoardList = boardService.useBoardList("1");
			
//			request.getServletContext().setAttribute("boardList", newBoardList);
//			request.getServletContext().setAttribute("boardList", boardList);
//			response.sendRedirect(request.getContextPath()+"/manageBoard");
			
			List<BoardVo> allBoardList = boardService.allBoardList();
			request.getServletContext().setAttribute("boardList", allBoardList);
			
			doGet(request, response);
			
			logger.debug("insertCnt : {}",insertCnt);
			
			
		}
			
	
	}

}
