package myspring.user.dao.mapper;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserMapper {
	UserVO selectUserByUserid(String userid);
	List<UserVO> selectUserList();
	int insertUser(UserVO user);
	int updateUser(UserVO user);
	int deleteUser(int id);
} 
