package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.UserVo;

public interface IUserDao {
	
	/**
	* Method : userList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	List<UserVo> userList();
	
	/**
	* Method : getUser
	* 작성자 : PC22
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 특정사용자 조회
	*/
	UserVo getUser(String userId);
	
	

}
