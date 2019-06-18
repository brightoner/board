package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;


@WebServlet("/fileDelete")
@MultipartConfig(maxFileSize=1024*1024*3,maxRequestSize=1024*1024*15)
public class FileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("utf-8");
		String attach_id = request.getParameter("attach_id");
		int deleteCnt = boardService.deleteFile(attach_id);
		if(deleteCnt > 0) {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			int post_id = Integer.parseInt(request.getParameter("post_id"));
			String title = request.getParameter("title");
			String content = request.getParameter("smarteditor");
			List<AttachVo> attachList = boardService.getAttach(post_id);
			request.setAttribute("attachList", attachList);
			request.setAttribute("post_id", post_id);
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("right", "update");
			request.setAttribute("board_id", board_id);
			request.getRequestDispatcher("/post/insertPostTest.jsp").forward(request, response);
		}
	
	}

}
