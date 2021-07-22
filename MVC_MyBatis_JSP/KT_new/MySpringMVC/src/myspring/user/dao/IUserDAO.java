package myspring.user.dao;

import java.util.List;

import myspring.user.vo.UserVO;

public interface IUserDAO {

	// User ����Ʈ
	List<UserVO> getUsers();

	// User 1�� ��ȸ
	UserVO getUser(String userid);

	// User Update
	int updateUser(UserVO user);

	// User Delete
	int deleteUser(int id);

	// User Insert
	int insertUser(UserVO user);

}