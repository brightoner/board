package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;


@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IBoardService  boardService;
    @Override
    public void init() throws ServletException {
    	boardService = new BoardService();
    }
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String attach_id = request.getParameter("myfile_id");
		AttachVo attachVo = boardService.getFile(attach_id);
		
		String temp = attachVo.getPath();
		int index = temp.lastIndexOf("\\");
		String path = temp.substring(0, index+1);
		String fileName = temp.substring(index+1);
		String viewFileName = attachVo.getFilename();
		
		request.setAttribute("path", path);
		request.setAttribute("fileName", fileName);
		request.setAttribute("viewFileName", viewFileName);
		
		request.getRequestDispatcher("post/down.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
