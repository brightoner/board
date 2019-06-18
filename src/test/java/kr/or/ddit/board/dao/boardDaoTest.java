package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class boardDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(boardDaoTest.class);
	
	private IBoardDao boardDao;
	
	@Before
	public void setup(){
		boardDao = new BoardDao();
	}

	@Test
	public void allBoardListTest() {
		/***Given***/
		

		/***When***/
		List<BoardVo> allBoardList = boardDao.allBoardList();

		/***Then***/
		assertEquals(2, allBoardList.size());

	}

	@Test
	public void insertBoardTest(){
		/***Given***/
		
		BoardVo boardVo = null;
		 
		boardVo = new BoardVo(1, "자유게시판", "1");

		/***When***/
		int boardCnt = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, boardCnt);
		

		
	}
	
	/**
	* Method : boardPagingListTest
	* 작성자 : PC22
	* 변경이력 :
	* Method 설명 : 게시판 페이징리스트 조회
	*/
//	@Test
//	public void boardPagingListTest(){
//		/***Given***/
//		PageVo pageVo = new PageVo(1, 10, 1);
//		
//		/***When***/
//		List<PostVo> postList = boardDao.boardPagingList(map);
//		
//		
//		/***Then***/
//		assertNotNull(postList);
//		for(PostVo postVO : postList) {
//			logger.debug("postVO : {}", postVO);
//		}
//		assertEquals(6, postList.size());
//
//	}
	
	
	
	@Test
	public void updateTest(){
		/***Given***/
		PostVo postVo = null;
		
//		postVo = new PostVo("강아지", "멍멍");
		postVo = new PostVo(4, "고양이", "멍멍");
		
		/***When***/
		int updatePost = boardDao.updatePost(postVo);

		/***Then***/
		assertEquals(1, updatePost);
		
	}
	

	@Test
	public void deleteCntTest(){
		/***Given***/
		PostVo postVo = null;
		postVo = new PostVo(41, "brown", "야옹옹", "2");
		
		
		/***When***/
		int deleteCnt = boardDao.deletePost(41);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
	
	
	


	
	
	
}






