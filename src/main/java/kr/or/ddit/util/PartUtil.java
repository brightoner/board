package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PartUtil {

	private static final String UPLOAD_PATH = "c:\\upload\\";

	/**
	* Method : getFileName
	* 작성자 : PC22
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다
	*/


	public static String getFileName(String contentDisposition) {
		// // form-date; name="profile"; filename="sally.png"
		//"form-date; name=\"profile\"; filename=\"sally.png\""
		
		String[] splited = contentDisposition.split("; ");
		for(String split : splited){
			if(split.startsWith("filename") ){
				int startIndex = split.indexOf("\"") +1 ;
				int lastIndex = split.lastIndexOf("\"");
				
				return split.substring(startIndex, lastIndex);
			}
		}
		return "";
	}

	/**
	* Method : getExt
	* 작성자 : PC22
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로 부터 파일 확장자를 반환
	*/
	public static String getExt(String fileName) {
		String ext = ""; 
//		String[] splited = fileName.split("[.]");
		String[] splited = fileName.split("\\.");
		if(splited.length != 1)
			ext =  splited[splited.length-1];
		return ext.equals("") ? "" : "." + ext;		// .을 리턴
	

	}
	
	/**
	* Method : checkUploadFolder
	* 작성자 : PC22
	* 변경이력 :
	* @param yyyy
	* @param mm
	* Method 설명 : 년, 월 업로드 폴더가 존재하는지 체크, 없을경우 폴더 생성
	*/
	public static void checkUploadFolder(String yyyy, String mm){
		File yyyyFolder = new File(UPLOAD_PATH + yyyy);
		//신규년도로 넘어 갔을경우 해당년도의 폴더를 생성우
		if(!yyyyFolder.exists()){
			yyyyFolder.mkdir();
			
		}
		
		//월에 해당하는 폴더가 있는지 확인
		File mmFolder = new File(UPLOAD_PATH+ yyyy + File.separator + mm);
		if(!mmFolder.exists()){
			mmFolder.mkdir();
		}
		
	}
	
	/**
	* Method : getUploadPath
	* 작성자 : PC22
	* 변경이력 :
	* @param yyyy
	* @param mm
	* @return
	* Method 설명 : 럽로드 경로 반환
	*/
	public static String getUploadPath(){
		//업로드할 폴더 확인
		//파일을 받는폴더
		//년도에 해당하는 폴더가 있는지, 년도 안에 월에 해당하는 폴더가 있는지
		Date dt = new Date();
		SimpleDateFormat yyyyMMSdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = yyyyMMSdf.format(dt);
		String yyyy = yyyyMM.substring(0,4);
		String mm = yyyyMM.substring(4,6);
		
		PartUtil.checkUploadFolder(yyyy, mm);
		return UPLOAD_PATH + yyyy + File.separator + mm;
	}
	
	
	
}
















