package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.util.AttachUtil;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//답글
@WebServlet("/rePost")
@MultipartConfig(maxFileSize=1024*1024*3,maxRequestSize=1024*1024*15)
public class RePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(RePostController.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String board_id = request.getParameter("board_id");
		String post_id = request.getParameter("post_id");
		String group_seq = request.getParameter("group_seq");
		String parent_id = request.getParameter("parent_id");
		logger.debug("board_id : {}", board_id);
		logger.debug("post_id : {}", post_id);
		logger.debug("group_seq : {}", group_seq);
		logger.debug("parent_id : {}", parent_id);
		request.setAttribute("board_id", board_id);
		request.setAttribute("post_id", post_id);
		request.setAttribute("group_seq", group_seq);
		request.setAttribute("parent_id", parent_id);

		
		//첨부파일
		request.setAttribute("attachList", "");

		request.getRequestDispatcher("/post/insertPost.jsp").forward(request,response);
		

				logger.debug("board_id : {}", board_id);

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");

		String board_id = request.getParameter("board_id");
		String title = request.getParameter("title");
		String content = request.getParameter("smarteditor");
		String postuse_yn = request.getParameter("postuse_yn");
		String parent_id = request.getParameter("parent_id");
		String group_seq = request.getParameter("group_seq");
		String post_id = request.getParameter("post_id");
		
		logger.debug("post_id :{}",post_id);

		logger.debug("board_id : {}", board_id);
		logger.debug("title : {}", title);
		logger.debug("content : {}", content);

		UserVo userVo = (UserVo) request.getSession().getAttribute("USER_INFO");

		// 첨부파일업로드
//		Part attach0 = request.getPart("attach0");
//		Part attach1 = request.getPart("attach1");
//		Part attach2 = request.getPart("attach2");
//		Part attach3 = request.getPart("attach3");
//		Part attach4 = request.getPart("attach4");

		
		PostVo postVo = boardService.getPost(Integer.parseInt(post_id));
		
		PostVo postVo1 = new PostVo();
		postVo.setUserid(userVo.getUserid());
		postVo.setTitle(title);
		postVo.setContent(content);
		postVo.setBoard_id(Integer.parseInt(board_id));
		
//		postVo.setGroup_seq(Integer.parseInt(group_seq));
//		postVo.setParent_id(Integer.parseInt(parent_id));
		
		
		
		if(parent_id==null || parent_id.equals("")){
			postVo.setGroup_seq(0);
		}else{
			postVo.setGroup_seq(Integer.parseInt(group_seq));
		}
		if(parent_id==null || parent_id.equals("")){
			postVo.setParent_id(0);
		}else{
			postVo.setParent_id(Integer.parseInt(parent_id));
		}
		 postVo.setPost_id(Integer.parseInt(post_id));

		/*
		
		if (attach0 != null && attach0.getSize() > 0) {

			AttachVo attachVo = new AttachVo();
			String contentDisposition = attach0
					.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);

			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				String filePath = uploadPath + File.separator
						+ UUID.randomUUID().toString() + ext;
				attachVo.setPath(filePath);
				attachVo.setFilename(filename);
				attach0.write(filePath);
				attach0.delete();
			}

			boardService.insertAttach(attachVo);
		}
		if (attach1 != null && attach1.getSize() > 0) {

			AttachVo attachVo = new AttachVo();
			String contentDisposition = attach1
					.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);

			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				String filePath = uploadPath + File.separator
						+ UUID.randomUUID().toString() + ext;
				attachVo.setPath(filePath);
				attachVo.setFilename(filename);
				attach1.write(filePath);
				attach1.delete();
			}

			boardService.insertAttach(attachVo);
		}
		if (attach2 != null && attach2.getSize() > 0) {

			AttachVo attachVo = new AttachVo();
			String contentDisposition = attach2
					.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);

			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				String filePath = uploadPath + File.separator
						+ UUID.randomUUID().toString() + ext;
				attachVo.setPath(filePath);
				attachVo.setFilename(filename);
				attach2.write(filePath);
				attach2.delete();
			}

			boardService.insertAttach(attachVo);
		}
		if (attach3 != null && attach3.getSize() > 0) {

			AttachVo attachVo = new AttachVo();
			String contentDisposition = attach3
					.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);

			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				String filePath = uploadPath + File.separator
						+ UUID.randomUUID().toString() + ext;
				attachVo.setPath(filePath);
				attachVo.setFilename(filename);
				attach3.write(filePath);
				attach3.delete();
			}

			boardService.insertAttach(attachVo);
		}
		if (attach4 != null && attach4.getSize() > 0) {

			AttachVo attachVo = new AttachVo();
			String contentDisposition = attach4
					.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);

			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				String filePath = uploadPath + File.separator
						+ UUID.randomUUID().toString() + ext;
				attachVo.setPath(filePath);
				attachVo.setFilename(filename);
				attach4.write(filePath);
				attach4.delete();
			}

			boardService.insertAttach(attachVo);
		}

		*/

		PostVo rePostVo = new PostVo();
		rePostVo.setUserid(postVo1.getUserid());
		logger.debug("postVo1.getUserid():{}",postVo1.getUserid());
		rePostVo.setTitle(title);
		logger.debug("title:{}",title);
		rePostVo.setContent(content);
		logger.debug("content:{}",content);
		rePostVo.setParent_id(postVo1.getPost_id());
		logger.debug("postVo1.getPost_id():{}",postVo1.getPost_id());
		rePostVo.setBoard_id(postVo1.getBoard_id());
		logger.debug("postVo1.getBoard_id():{}",postVo1.getBoard_id());
		rePostVo.setGroup_seq(postVo1.getGroup_seq());
		logger.debug("postVo1.getGroup_seq():{}",postVo1.getGroup_seq());
		
		
		int insertCnt = boardService.insertRePost(rePostVo);

		logger.debug("insertCnt :{}", insertCnt);

		if (insertCnt == 1) {
			
			
			//첨부파일
			Collection<Part> parts = request.getParts();
			for(Part part : parts){
				if("attach".equals(part.getName()) && part.getSize() >0){
					AttachUtil.fileUpload(part, Integer.parseInt(post_id));
				}
			}
			
			response.sendRedirect(request.getContextPath() + "/post?post_id="+ boardService.currentPost());

		} 

		
	}

}
