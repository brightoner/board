package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.AttachVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class BoardDao implements IBoardDao {
	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(BoardDao.class);

	/**
	* Method : insertBoard
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 등록
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession SqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = SqlSession.insert("board.insertBoard", boardVo);
		SqlSession.commit();
		SqlSession.close();
		return insertCnt;
	}

	/**
	* Method : boardList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 자유게시판 전체 글 조회
	*/
	@Override
	public List<PostVo> boardList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> boardList = sqlSession.selectList("board.boardList");
		sqlSession.close();
		return boardList;
	}
	


	/**
	* Method : boardCnt
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 수
	*/
	@Override
	public int boardCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int boardCnt = sqlSession.selectOne("board.boardCnt");
		sqlSession.close();
		return boardCnt;
	}

	/**
	* Method : allBoardList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 정보를 조회
	*/
	@Override
	public List<BoardVo> allBoardList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.allBoardList");
		sqlSession.close();
		return boardList;
	}

	/**
	* Method : useBoardList 
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 사용중인 게시판 정보조회
	*/
	@Override
	public List<BoardVo> useBoardList(String use_yn) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> userBoardList = sqlSession.selectList("board.useBoardList", use_yn);
		sqlSession.close();
		return userBoardList;
	}

	
	/**
	* Method : getBoard
	* 작성자 : PC22
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 특정게시판 조회
	*/
	@Override
	public BoardVo getBoard(int board_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BoardVo boardVo = sqlSession.selectOne("board.getBoard", board_id);
		sqlSession.close();
		return null;
	}

	/**
	* Method : getPost
	* 작성자 : PC22
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 상세보기
	*/
	@Override
	public PostVo getPost(int post_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		PostVo postVo = sqlSession.selectOne("board.getPost", post_id);
		sqlSession.close();
		return postVo;
	}

	/**
	* Method : getAttach
	* 작성자 : PC22
	* 변경이력 :
	* @param attach_id
	* @return
	* Method 설명 : 첨부파일 정보가져오기
	*/
	@Override
	public AttachVo getAttach(String attach_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AttachVo attachVo = sqlSession.selectOne("board.getAttach", attach_id);
		sqlSession.close();
		return attachVo;
	}


	/**
	* Method : getAllPost
	* 작성자 : PC22
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 특정게시판글 모두 조회
	*/
	@Override
	public BoardVo getAllPost(int board_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BoardVo boardVo = sqlSession.selectOne("board.getAllPost");
		sqlSession.close();
		return null;
	}

	/**
	 * Method : textPagingList
	 * 작성자 : PC22
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 페이징 리스트 조회
	 */
	@Override
	public List<PostVo> boardPagingList(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> postList = sqlSession.selectList("board.boardPagingList", map);
		sqlSession.close();
		return postList;
	}

	/**
	* Method : insertAttach
	* 작성자 : PC22
	* 변경이력 :
	* @param attachVo
	* @return
	* Method 설명 : 첨부파일등록
	*/
	@Override
	public int insertAttach(AttachVo attachVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertFile = sqlSession.insert("board.insertAttach", attachVo);
		sqlSession.commit();
		sqlSession.close();
		return insertFile;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("board.updateUseBoard", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertPostCnt = sqlSession.insert("board.insertPost", postVo);
		sqlSession.commit();
		sqlSession.close();
		return insertPostCnt;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int post_id = sqlSession.selectOne("board.currentPost");
//		sqlSession.commit();
		sqlSession.close();
		return post_id;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("board.updatePost", postVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("board.deletePost", post_id);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> changePost = sqlSession.selectList("board.getUsePost");
		sqlSession.commit();
		sqlSession.close();
		return null;
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
		logger.debug("replyVo",replyVo);
		SqlSession sqlSEssion = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSEssion.insert("board.insertReply",replyVo);
		sqlSEssion.commit();
		sqlSEssion.close();
		return insertCnt;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ReplyVo> replyList = sqlSession.selectList("board.getReply",post_id);
		sqlSession.commit();
		sqlSession.close();
		return replyList;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<AttachVo> attachList = sqlSession.selectList("board.getAttach", post_id);
		sqlSession.commit();
		sqlSession.close();
		return attachList;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.useYBoard");
		sqlSession.close();
		return boardList;
	}

	/**
	* Method : postCnt
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 특정게시판 수
	*/
	@Override
	public int postCnt(int board_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int postCnt = sqlSession.selectOne("board.postCnt", board_id);
		sqlSession.close();
		return postCnt;
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
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertRePost = sqlSession.insert("board.insertRePost", postVo);
		sqlSession.commit();
		sqlSession.close();
		return insertRePost;
	}

	@Override
	public List<PostVo> getUseReply() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> changeReply = sqlSession.selectList("board.getUseReply");
		sqlSession.commit();
		sqlSession.close();
		
		return changeReply;
	}

	@Override
	public int deleteRePost(int reply_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("board.deleteRePost", reply_id);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int inserAttch(AttachVo attachVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("board.inserAttch", attachVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public AttachVo getFile(String attach_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AttachVo attachVo = sqlSession.selectOne("board.getFile", attach_id);
		sqlSession.close();
		return attachVo;
	}

	@Override
	public int deleteFile(String attach_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("board.deleteFile", attach_id);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}



	

	
	

	
	


	
	
	
	
	
	
	
	

}
