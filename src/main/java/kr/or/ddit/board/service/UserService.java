package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IUserDao;
import kr.or.ddit.board.dao.UserDao;
import kr.or.ddit.board.model.UserVo;


public class UserService implements IUserService {
	
	private IUserDao dao =new UserDao();

	/**
	* Method : userList
	* 작성자 : PC22
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<UserVo> userList() {
		return dao.userList();
	}


	/**
	* Method : getUser
	* 작성자 : PC22
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVo getUser(String userId) {
		return dao.getUser(userId);
	}



}
