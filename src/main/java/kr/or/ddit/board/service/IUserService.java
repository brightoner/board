package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.UserVo;

public interface IUserService {
	
	/**
	* Method : userList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	List<UserVo> userList();
	
	/**
	* Method : getUser
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 특정 사용자 정보 조회
	*/
	UserVo getUser(String userId);

}
