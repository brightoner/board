package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;

public interface IBoardDao {
	
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
	* Method : boardPagingList
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 자유게시판 페이징 리스트 조회
	*/
	List<PostVo> boardPagingList(PageVo pageVo);
	
	/**
	* Method : boardCnt
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 자유게시판 전체 조회
	*/
	int boardCnt();
	
	/**
	* Method : allBoardList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 모든 보드 정보를 조회
	*/
	List<BoardVo> allBoardList();

}
