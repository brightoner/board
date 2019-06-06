package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/freeboardPagingList")
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

		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null? 10 : Integer.parseInt(pageSizeString);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> resultMap = boardService.boardPagingList(pageVo);
		List<PostVo> boardList = (List<PostVo>) resultMap.get("boardList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/board/boardPagingList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
