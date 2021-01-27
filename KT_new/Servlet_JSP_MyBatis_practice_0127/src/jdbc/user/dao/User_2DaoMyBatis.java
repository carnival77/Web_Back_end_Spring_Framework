package jdbc.user.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.compiler.ast.IntConst;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jdbc.user.vo.User_2VO;

public class User_2DaoMyBatis {
	private SqlSessionFactory sqlsessfac;

	public User_2DaoMyBatis() {
		String resource = "SqlMapConfig.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlsessfac = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int updateUser(User_2VO user) {
		int updCnt = 0;
		SqlSession session = null;

		try {
			session = sqlsessfac.openSession();
			session.getConnection().setAutoCommit(false);
			updCnt = session.update("user_2NS.updateUser", user);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}

		return updCnt;
	}

	public int insertUser(User_2VO user) {
		int intCnt = 0;
		SqlSession session = null;

		try {
			session = sqlsessfac.openSession();
			session.getConnection().setAutoCommit(false);
			intCnt = session.update("user_2NS.insertUser", user);
			if (intCnt > 0) {
				session.commit();
			} else {
				session.rollback();
			}
//			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return intCnt;
	}

	public List<User_2VO> getUserList() {
		List<User_2VO> userList = null;
		SqlSession session = sqlsessfac.openSession();

		try {
			userList = session.selectList("user_2NS.selectUserList");
		} finally {
			session.close();
		}

		return userList;
	}

	public User_2VO getUser(String name) {
		User_2VO user = null;

		SqlSession session = sqlsessfac.openSession();

		try {
			user = session.selectOne("user_2NS.selectUserByName", name);
		} finally {
			session.close();
		}

		return user;
	}

	public int deleteUser(String name) {
		int delCnt = 0;
		SqlSession session = null;

		try {
			session = sqlsessfac.openSession();
			session.getConnection().setAutoCommit(false);
			delCnt = session.delete("user_2NS.deleteUser", name);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delCnt;
	}
}
