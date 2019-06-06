package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

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
		 
		boardVo = new BoardVo("brown", "익명게시판", "y");

		/***When***/
		int boardCnt = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, boardCnt);

		
	}
	
}






