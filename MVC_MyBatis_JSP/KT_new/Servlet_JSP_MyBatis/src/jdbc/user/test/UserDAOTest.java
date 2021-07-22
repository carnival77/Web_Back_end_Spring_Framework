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
	
	@Test
	public void updateUser() {
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser("Dongmin");
		dao.updateUser(user);
		System.out.println(user);
		
//		assertEquals("�ŵ���", actual);
	}
	
//	@Test @Ignore
//	public void insertUser() {
//		UserVO user = new UserVO("dooly","�Ѹ�","��","�λ�");
//		int cnt = dao.insertUser(user);
//		assertEquals(1, cnt);
//	}

	@Test
	public void getUser() {
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser("Dongmin");
		System.out.println(user);

		assertEquals("�ŵ���", user.getName());
	}
}
