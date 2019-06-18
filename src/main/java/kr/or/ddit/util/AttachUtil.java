package kr.or.ddit.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

public class AttachUtil {
	
	private static IBoardService boardService;
	
	static{
		boardService = new BoardService();
	}
	
	public static void fileUpload(Part file, int post_id) throws IOException {
		String contentDisposition = file.getHeader("content-disposition");
		String filename = PartUtil.getFileName(contentDisposition);
		String ext = PartUtil.getExt(filename);
		String uploadPath = PartUtil.getUploadPath();
		
		// 파일 디스크에 쓰기
		String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
		AttachVo attachVo = new AttachVo(post_id, filePath, filename);
		boardService.insertAttach(attachVo);
		
		file.write(filePath);
		file.delete(); // 임시파일 지우기
	}
	
	public static boolean deleteFile(AttachVo attachVo) {
		boolean result = false;
		File file = new File(attachVo.getPath());
		
		if(file.exists())
			result = file.delete();
		
		return result;
		
	}
	
}
