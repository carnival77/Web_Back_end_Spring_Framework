package myspring.user.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.vo.UserVO;

@Repository
public class UserDAOImpl implements IUserDAO {

//	@Autowired
//	private final SqlSession session;

	@Autowired
	private UserMapper userMapper;

	public UserDAOImpl() {
		System.out.println("UserDAO �⺻������ ȣ���");
	}

//	public UserDAOImpl(SqlSession session) {
//		this.session = session;
//	}

	// User ����Ʈ
	@Override
	public List<UserVO> getUsers() {
		return userMapper.selectUserList();
	}

	// User 1�� ��ȸ
	@Override
	public UserVO getUser(String userid) {
//		return session.selectOne("userNS.selectUserByUserid", userid);
		return userMapper.selectUserByUserid(userid);
	}

	// User Update
	@Override
	public int updateUser(UserVO user) {
		return userMapper.updateUser(user);
	}

	// User Delete
	@Override
	public int deleteUser(int id) {
		return userMapper.deleteUser(id);
	}

	// User Insert
	@Override
	public int insertUser(UserVO user) {
		return userMapper.insertUser(user);
	}
}
