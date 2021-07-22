package jdbc.user.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import jdbc.user.dao.UserDAOMyBatis;
import jdbc.user.vo.UserVO;

public class UserDAOMyBatisTest {
	UserDAOMyBatis dao;
	
	@Before
	public void init() {
		dao = new UserDAOMyBatis();
	}
	
	@Test
	public void delete() {
		int cnt = dao.deleteUser(1);
		System.out.println("������ �Ǽ� " + cnt);
	}
	
	
	
	@Test @Ignore
	public void update() {
		UserVO user = new UserVO("test", "�׽�Ʈ33", "��33", "���33");
		int cnt = dao.updateUser(user);
		System.out.println("���ŵ� �Ǽ� " + cnt);
		
		List<UserVO> users = dao.getUsers();
		for (UserVO userVO : users) {
			System.out.println(userVO);
		}
	}
	
	@Test @Ignore
	public void insert() {
		UserVO user = new UserVO("test", "�׽�Ʈ", "��", "���");
		int cnt = dao.insertUser(user);
		Assert.assertEquals(1, cnt);
	}
	
	
	@Test @Ignore
	public void selectList( ) {
		List<UserVO> users = dao.getUsers();
		for (UserVO userVO : users) {
			System.out.println(userVO);
		}
	}
	
	
	@Test @Ignore
	public void selectOne() {
		UserVO user = dao.getUser("gildong");
		System.out.println(user);
	}
	
	
	
}
