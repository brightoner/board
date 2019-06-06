package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import kr.or.ddit.board.dao.IUserDao;
import kr.or.ddit.board.dao.UserDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class userDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(userDaoTest.class);
	
	private IUserDao dao;
	
	@Before
	public void setup(){
		dao = new UserDao();
		logger.debug("setup");
	}

	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVo userVo = dao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());
		logger.debug("userVo : {}", userVo);

	}
	
	

}
