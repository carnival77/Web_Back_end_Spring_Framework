package myspring.user.dao;

import java.util.List;

import myspring.user.vo.UserVO;

public interface IUserDAO {

	//User 1°Ç Á¶È¸
	UserVO getUser(String userid);

	List<UserVO> getUsers();

	int insertUser(UserVO user);

	int updateUser(UserVO user);

	int deleteUser(int id);

}