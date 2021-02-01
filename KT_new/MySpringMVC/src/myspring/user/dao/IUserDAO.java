package myspring.user.dao;

import java.util.List;

import myspring.user.vo.UserVO;

public interface IUserDAO {

	// User 리스트
	List<UserVO> getUsers();

	// User 1건 조회
	UserVO getUser(String userid);

	// User Update
	int updateUser(UserVO user);

	// User Delete
	int deleteUser(int id);

	// User Insert
	int insertUser(UserVO user);

}