package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

public class BoardDao implements IBoardDao {

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
	* Method : boardPagingList
	* 작성자 : PC22
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 자유게시판 페이징 리스트 조회
	*/
	@Override
	public List<PostVo> boardPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> boardPagingList = sqlSession.selectList("board.boardPagingList", pageVo);
		sqlSession.close();
		return boardPagingList;
	}

	/**
	* Method : freeBoardCnt
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 자유게시판 전체 조회
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
	* Method 설명 : 모든 보드 정보를 조회
	*/
	@Override
	public List<BoardVo> allBoardList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.allBoardList");
		sqlSession.close();
		return boardList;
	}
	
	
	
	
	
	
	
	

}
