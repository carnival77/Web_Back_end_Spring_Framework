package jdbc.user.test;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import jdbc.user.dao.UserDAOMyBatis;
import jdbc.user.vo.UserVO;
import junit.framework.Assert;

public class UserDAOMyBatisTest {
	UserDAOMyBatis dao;

	@Before
	public void init() {
		dao = new UserDAOMyBatis();
	}

	@Test
	public void delete() {
		int cnt = dao.deleteUser(1);
		System.out.println("삭제된 건수 : "+cnt);
	}
	
	@Test @Ignore
	public void insert() {
		UserVO user = new UserVO("test", "테스트", "여", "경기");
		int cnt = dao.insertUser(user);
		Assert.assertEquals(1, cnt);
	}

	@Test @Ignore
	public void update() {
		UserVO user = new UserVO("test", "테스트22", "여22", "경기22");
		int cnt = dao.updateUser(user);
		System.out.println("갱신된 건수 :" + cnt);
	}

	@Test
	public void selectList() {
		List<UserVO> users = dao.getUser();
		for (UserVO userVO : users) {
			System.out.println(userVO);
		}
	}

	@Test
	public void selectOne() {
		UserVO user = dao.getUser("Dongmin");
		System.out.println(user);
	}

}
