package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;

public interface IBoardService {
	
	/**
	* Method : insertBoard
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 생성
	*/
	int insertBoard(BoardVo boardVo);
	
	/**
	* Method : boardList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 자유게시판 전체 글 조회
	*/
	List<PostVo> boardList();
	
	/**
	* Method : bagingList
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 자유게시판 페이징 처리 
	*/
	Map<String, Object> boardPagingList(PageVo pageVo);

	/**
	* Method : allBoardList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 모든 보드 정보를 조회
	*/
	List<BoardVo> allBoardList();
	

}
