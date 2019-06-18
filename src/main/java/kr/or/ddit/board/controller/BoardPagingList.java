package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//게시판 페이지 네이션(게시판별 조회)
@WebServlet("/boardList")
public class BoardPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardPagingList.class);
	
	private BoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//left.jsp에서 board_id 값
		int board_id = Integer.parseInt(request.getParameter("board_id"));
//		boardService.getAllPost(board_id);
		boardService.getBoard(board_id);
		request.setAttribute("board_id", board_id);
		
		BoardVo boardVo = boardService.getBoard(board_id);
	
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null? 10 : Integer.parseInt(pageSizeString);
		
		logger.debug("page : {}",page);
		logger.debug("pageSize : {}",pageSize);
		
		PageVo pageVo = new PageVo(page, pageSize, board_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("board_id", board_id);
		
		Map<String, Object> resultMap = boardService.boardPagingList(map);
		logger.debug("resultMap:{}",resultMap);
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		String post_id = request.getParameter("post_Id");
		
		PostVo postVo = new PostVo();
//		postVo.setPost_id(Integer.parseInt(post_id));
		postVo.setBoard_id(board_id);
		
		List<PostVo> postList = (List<PostVo>) resultMap.get("postList");
		logger.debug("postList:{}",postList);
		
		logger.debug("paginationSize : {}", paginationSize);
		
		for(PostVo vo : postList){
			vo.setTitle(vo.getTitle().replace(" ", "&nbsp;"));
		}
		
		
		
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		//활성화된 메뉴정보
//		request.setAttribute("boardList", boardService.useBoardList("use_yn"));
		getServletContext().setAttribute("boardList", boardService.useBoardList("1"));
		//해당게시판의 모든 게시글
		request.setAttribute("postList", postList);
		
		
		request.setAttribute("board_id", board_id);
		
		request.getRequestDispatcher("/board/boardPagingList.jsp").forward(request, response);
		
	}
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
