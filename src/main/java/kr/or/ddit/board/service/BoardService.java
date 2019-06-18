package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.util.AttachUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BoardService implements IBoardService {

	private static final Logger logger = LoggerFactory
		.getLogger(BoardService.class);	

	private IBoardDao dao = new BoardDao();
	private static BoardService service;

	/**
	* Method : insertBoard
	* 작성자 : PC22
	* 변경이력 :
	* 
	 * @return Method 설명 : 게시판 등록
	 */
	@Override
	public int insertBoard(BoardVo boardVo) {
		return dao.insertBoard(boardVo);
	}

	/**
	 * Method : boardList 작성자 : PC22 변경이력 :
	 * 
	 * @return Method 설명 : 자유게시판 전체 글 조회
	 */
	@Override
	public List<PostVo> boardList() {
		return dao.boardList();
	}

	

	/**
	 * Method : allBoardList 작성자 : PC22z 변경이력 :
	 * 
	 * @return Method 설명 : 보드 정보를 조회
	 */
	@Override
	public List<BoardVo> allBoardList() {
		return dao.allBoardList();
	}

	/**
	 * Method : useBoardList 작성자 : PC22 변경이력 :
	 * 
	 * @return Method 설명 : 사용중인 게시판 정보 조회
	 */
	@Override
	public List<BoardVo> useBoardList(String use_yn) {
		return dao.useBoardList(use_yn);
	}

	/**
	 * Method : getBoard 작성자 : PC22 변경이력 :
	 * 
	 * @param board_id
	 * @return Method 설명 : 특정게시판 조회
	 */
	@Override
	public BoardVo getBoard(int board_id) {
		return dao.getBoard(board_id);
	}

	/**
	 * Method : getPost 작성자 : PC22 변경이력 :
	 * 
	 * @param post_id
	 * @return Method 설명 : 게시글 상세보기
	 */
	@Override
	public PostVo getPost(int post_id) {
		return dao.getPost(post_id);
	}

	/**
	 * Method : getAttach 작성자 : PC22 변경이력 :
	 * 
	 * @param attach_id
	 * @return Method 설명 : 첨부파일 정보가져오기
	 */
	@Override
	public AttachVo getAttach(String attach_id) {
		return dao.getAttach(attach_id);
	}

	/**
	 * Method : insertFile 작성자 : PC22 변경이력 :
	 * 
	 * @param attachVo
	 * @return Method 설명 : 첨부파일등록
	 */
	@Override
	public int insertAttach(AttachVo attachVo) {
		return dao.insertAttach(attachVo);
	}

	/**
	 * Method : getAllPost 작성자 : PC22 변경이력 :
	 * 
	 * @param board_id
	 * @return Method 설명 : 특정게시판 글 모두 조회
	 */
	@Override
	public BoardVo getAllPost(int board_id) {
		return dao.getAllPost(board_id);
	}

	/**
	* Method : updateUseBoard
	* 작성자 : PC22
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 사용유무 수정
	*/
	@Override
	public int updateUseBoard(BoardVo boardVo) {
		return dao.updateUseBoard(boardVo);
	}

	/**
	* Method : insertPost
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 새 게시글 생성
	*/
	@Override
	public int insertPost(PostVo postVo) {
		return dao.insertPost(postVo);
	}

	/**
	* Method : currentBoard
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 새 게시글 생성시 게시글번호로 상세보기
	*/
	@Override
	public int currentPost() {
		return dao.currentPost();
	}

	
	/**
	* Method : updatePost
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글수정
	*/
	@Override
	public int updatePost(PostVo postVo) {
		return dao.updatePost(postVo);
	}

	/**
	* Method : deletePost
	* 작성자 : PC22
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 사용 n 업데이트
	*/
	@Override
	public int deletePost(int post_id) {
		return dao.deletePost(post_id);
	}

	/**
	* Method : getUsePost
	* 작성자 : PC22
	* 변경이력 :
	* @param 
	* @return
	* Method 설명 : 사용중인 게시판만 조회
	*/
	@Override
	public List<PostVo> getUsePost() {
		return dao.getUsePost();
	}

	/**
	* Method : insertReply
	* 작성자 : PC22
	* 변경이력 :
	* @param : replyVo
	* @return
	* Method 설명 : 댓글 쓰기
	*/
	@Override
	public int insertReply(ReplyVo replyVo) {
		return dao.insertReply(replyVo);
	}

	/**
	* Method : getReply
	* 작성자 : PC22
	* 변경이력 :
	* @param : post_id
	* @return
	* Method 설명 : 댓글 검색
	*/
	@Override
	public List<ReplyVo> getReply(int post_id) {
		return dao.getReply(post_id);
	}

	/**
	* Method : getAttach
	* 작성자 : PC22
	* 변경이력 :
	* @param : parseInt
	* @return
	* Method 설명 : 각각 게시물별댓글 검색
	*/
	@Override
	public List<AttachVo> getAttach(int post_id) {
		return dao.getAttach(post_id);
	}

	/**
	* Method : useYBoard
	* 작성자 : PC22
	* 변경이력 :
	* @param : 
	* @return
	* Method 설명 : 사용중인 게시판
	*/
	@Override
	public List<BoardVo> useYBoard() {
		return dao.useYBoard();
	}

	/**
	* Method : pagingList
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 자유게시판 페이징 처리 
	*/
	@Override
	public Map<String, Object> boardPagingList(Map<String, Object> map) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("postList", dao.boardPagingList(map));
//		int postCnt = dao.postCnt(board_id);
//		
//		int paginationSize = (int)Math.ceil(postCnt/);
//		resultMap.put("pagenationSize", pagenationSize);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postList", dao.boardPagingList(map));
		int postCnt = dao.postCnt((int)map.get("board_id"));
		int paginationSize = (int) Math.ceil((double)postCnt/(int)map.get("pageSize"));
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	
	/**
	* Method : insertRePost
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 답글 생성
	*/
	@Override
	public int insertRePost(PostVo postVo) {
		return dao.insertRePost(postVo);
	}

	@Override
	public List<PostVo> getUseReply() {
		return dao.getUseReply();
	}

	@Override
	public int deleteRePost(int reply_id) {
		return dao.deleteRePost(reply_id);
	}



	@Override
	public AttachVo getFile(String attach_id) {
		return dao.getFile(attach_id);
	}

	@Override
	public int deleteFile(String attach_id) {
		AttachVo attachVo = dao.getFile(attach_id);
		boolean result = AttachUtil.deleteFile(attachVo);
		
		return dao.deleteFile(attach_id);
	}





	
}
