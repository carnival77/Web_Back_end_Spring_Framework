package jdbc.user.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

public class UserDAOTest {
	UserDAO dao;
	
	
	@Before
	public void init() {
		dao = new UserDAO();
	}
	
	@Test @Ignore
	public void insertUser() {
//		UserVO user = new UserVO("dooly", "둘리", "남", "부산");
//		int cnt = dao.insertUser(user);
//		assertEquals(1, cnt);
	}
	
	
	@Test
	public void getUser() {
		UserVO user = dao.getUser("gildong");
		System.out.println(user);
		//Assert.assertEquals()
		assertEquals("홍길동", user.getName());
		
	}
}
