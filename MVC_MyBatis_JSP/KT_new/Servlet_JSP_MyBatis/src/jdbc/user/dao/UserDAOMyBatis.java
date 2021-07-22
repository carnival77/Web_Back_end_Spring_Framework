package jdbc.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jdbc.user.vo.UserVO;

public class UserDAOMyBatis {
	private SqlSessionFactory sqlSessionFactory;

	public UserDAOMyBatis() {
		String resource = "SqlMapConfig.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// User Update
	public int updateUser(UserVO user) {
		int updCnt = 0;
		SqlSession session = null;

		try {
			session = sqlSessionFactory.openSession();
			Connection connection = session.getConnection();
			// auto commit mode 해제
			connection.setAutoCommit(false);
			updCnt = session.update("userNS.updateUser", user);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}

		return updCnt;
	}

	// User Delete
	public int deleteUser(int id) {
		int delCnt = 0;
		SqlSession session = null;

		try {
			session = sqlSessionFactory.openSession();
//			Connection connection = session.getConnection();
//			connection.setAutoCommit(false);
			session.getConnection().setAutoCommit(false);
			delCnt = session.delete("userNS.deleteUser", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return delCnt;
	}

	// User Insert
	public int insertUser(UserVO user) {
		int insCnt = 0;
		SqlSession session = null;

		try {
			session = sqlSessionFactory.openSession();
			insCnt = session.insert("userNS.insertUser", user);
			if (insCnt > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return insCnt;
	}

	// User 리스트
	public List<UserVO> getUsers() {
		List<UserVO> userList = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			userList = session.selectList("userNS.selectUserList");
		} finally {
			session.close();
		}

		return userList;
	}

	// User 1건 조회
	public UserVO getUser(String userid) {
		UserVO user = null;

		SqlSession session = sqlSessionFactory.openSession();

		try {
			user = session.selectOne("userNS.selectUserByUserid", userid);
		} finally {
			session.close();
		}

		return user;
	}

}
