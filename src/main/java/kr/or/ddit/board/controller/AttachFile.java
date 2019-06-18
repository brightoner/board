package kr.or.ddit.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

//첨부파일업로드
@WebServlet("/attachFile")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class AttachFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String attach_id = request.getParameter("attach_id");
		
		AttachVo attachVo = boardService.getAttach(attach_id);
		
		ServletOutputStream sos = response.getOutputStream();
		
		FileInputStream fis = null;
		String filePath = null;
		
		if(attachVo.getPath() != null){
			filePath = attachVo.getPath();
		}else{
			filePath = getServletContext().getRealPath("/img/no_image.gif");
		}
		
		File file = new File(filePath);
		fis = new FileInputStream(file);
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer, 0, 512) != -1){
			sos.write(buffer);
		}
		
		fis.close();
		sos.close();
		
	}

	
}









