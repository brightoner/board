package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class boardServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(boardServiceTest.class);
	
	private IBoardService boardService; 

	@Before
	public void setup(){
		boardService = new BoardService();
	}
	
	
	
	
	@Test
	public void allBoardListTest() {
		/***Given***/
		

		/***When***/
		List<BoardVo> allBoardList = boardService.allBoardList();

		/***Then***/
		assertEquals(2, allBoardList.size());

	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		
		BoardVo boardVo = null;
		 
		boardVo = new BoardVo(1, "자유게시판", "1");

		/***When***/
		int boardCnt = boardService.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, boardCnt);
		

		
	}
	
	
	@Test
	public void updateTest(){
		/***Given***/
		PostVo postVo = null;
		
//		postVo = new PostVo("강아지", "멍멍");
		postVo = new PostVo(1, "강아지", "멍멍");
		
		/***When***/
		int updatePost = boardService.updatePost(postVo);

		/***Then***/
		assertEquals(1, updatePost);

	}
	
	@Test
	public void deleteCntTest(){
		/***Given***/
		PostVo postVo = null;
		postVo = new PostVo(41, "brown", "야옹옹", "1");
		
		
		/***When***/
		int deleteCnt = boardService.deletePost(4);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
	
	
	
	
	
}
