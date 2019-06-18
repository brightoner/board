package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.model.ReplyVo;

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
	* Method : pagingList
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 자유게시판 페이징 처리 
	*/
	Map<String, Object> boardPagingList(Map<String, Object> map);

	/**
	* Method : allBoardList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 모든 보드 정보를 조회
	*/
	List<BoardVo> allBoardList();
	
	
	/**
	* Method : useBoardList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 사용중인 게시판 조화
	*/
	List<BoardVo> useBoardList(String use_yn);
	
	/**
	* Method : getBoard
	* 작성자 : PC22
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 특정게시판 조회
	*/
	BoardVo getBoard(int board_id);
	
	
	/**
	* Method : getPost
	* 작성자 : PC22
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 상세보기
	*/
	PostVo getPost(int post_id);
	
	
	/**
	* Method : getAttach
	* 작성자 : PC22
	* 변경이력 :
	* @param attach_id
	* @return
	* Method 설명 : 첨부파일 정보가져오기
	*/
	AttachVo getAttach(String attach_id);

	/**
	* Method : insertAttach
	* 작성자 : PC22
	* 변경이력 :
	* @param attachVo
	* @return
	* Method 설명 : 첨부파일 등록
	*/
	int insertAttach(AttachVo attachVo);
	
	
	/**
	* Method : getAllPost
	* 작성자 : PC22
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 특정게시판 글 모두 조회
	*/
	BoardVo getAllPost(int board_id);

	/**
	* Method : updateUseBoard
	* 작성자 : PC22
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 사용유무 수정
	*/
	int updateUseBoard(BoardVo boardVo);


	/**
	* Method : insertPost
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 새 게시글 생성
	*/
	int insertPost(PostVo postVo);
	
	/**
	* Method : currentBoard
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 새 게시글 생성시 게시글번호로 상세보기
	*/
	int currentPost();
	

	/**
	* Method : updatePost
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글수정
	*/
	int updatePost(PostVo postVo);

	/**
	* Method : deletePost
	* 작성자 : PC22
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 사용 n 업데이트
	*/
	int deletePost(int post_id);

	/**
	* Method : getUsePost
	* 작성자 : PC22
	* 변경이력 :
	* @param 
	* @return
	* Method 설명 : 사용중인 게시판만 조회
	*/
	List<PostVo> getUsePost();

	/**
	* Method : insertReply
	* 작성자 : PC22
	* 변경이력 :
	* @param : replyVo
	* @return
	* Method 설명 : 댓글 쓰기
	*/
	int insertReply(ReplyVo replyVo);

	/**
	* Method : getReply
	* 작성자 : PC22
	* 변경이력 :
	* @param : post_id
	* @return
	* Method 설명 : 댓글 검색
	*/
	List<ReplyVo> getReply(int post_id);



	/**
	* Method : useYBoard
	* 작성자 : PC22
	* 변경이력 :
	* @param : 
	* @return
	* Method 설명 : 사용중인 게시판
	*/
	List<BoardVo> useYBoard();

	/**
	* Method : insertRePost
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 답글 생성
	*/
	int insertRePost(PostVo postVo);

	List<PostVo> getUseReply();

	int deleteRePost(int reply_id);
	

	
	List<AttachVo> getAttach(int post_id);
	
	AttachVo getFile(String attach_id);
	
	int deleteFile(String attach_id);

	
	
	
	
}
