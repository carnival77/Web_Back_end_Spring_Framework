package jdbc.user.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import jdbc.user.dao.User_2DaoMyBatis;
import jdbc.user.vo.User_2VO;


public class User_2_DAOTest {
	User_2DaoMyBatis dao;
	
	@Before
	public void init() {
		dao = new User_2DaoMyBatis();
	}
	
	@Test @Ignore
	public void insert() {
		User_2VO user = new User_2VO("maria","������" );
		int cnt = dao.insertUser(user);
		Assert.assertEquals(1, cnt);
		
	}
	
	@Test @Ignore
	public void selectList() {
		List<User_2VO> userList = dao.getUserList();
		for (User_2VO user_2vo : userList) {
			System.out.println(user_2vo);
		}
	}
	
	@Test @Ignore
	public void selectOne() {
		User_2VO user = dao.getUser("����");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void update() {
		User_2VO user = new User_2VO("stam","�׽�Ʈ_�̸�");
		int cnt = dao.updateUser(user);
		System.out.println("���ŵǾ���? : "+cnt);
		selectList();
	}
	
	@Test
	public void delete() {
		int cnt = dao.deleteUser("�׽�Ʈ_�̸�");
		System.out.println("�����ƴ�? : "+cnt);
		selectList();
	}
	
	
}
