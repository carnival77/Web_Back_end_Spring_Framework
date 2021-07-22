package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.IUserDAO;
import myspring.user.dao.UserDAOImpl;
import myspring.user.dao.mapper.UserMapper;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/springbeans.xml")
public class DataSourceTest {
	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSessionFactory factory;

	@Autowired
	SqlSession session;

	@Autowired
	IUserDAO dao;

	@Autowired
	UserMapper mapper;

	@Test
	@Ignore
	public void mapper_selectOne() {
		UserVO user = mapper.selectUserByUserid("Dongmin");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void mapper_update() {
		UserVO user = new UserVO("Dongmin", "동민_2", "남", "여의도");
		mapper.updateUser(user);
		System.out.println(mapper.selectUserByUserid("Dongmin"));
	}

	@Test @Ignore
	public void mapper_insert() {
//		int result=1;
		UserVO user = new UserVO("Shin", "신", "남", "강서구");
		int result = mapper.insertUser(user);
		System.out.println((result==1)? "insert 성공":"insert 실패");
	}
	
	@Test 
	public void mapper_selectAll() {
		List<UserVO> users = mapper.selectUserList();
		for (UserVO userVO : users) {
			System.out.println(userVO);
		}
	}
	
	@Test @Ignore
	public void mapper_delete() {
		int result=mapper.deleteUser(4);
		System.out.println((result==1)? "delete 성공" : "delete 실패");
	}

	@Test
	@Ignore
	public void dao() {
		UserVO user = dao.getUser("Dongmin");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void sql() {
		UserVO user = session.selectOne("selectUserByUserid", "Dongmin");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void ds() {
		System.out.println(factory.getClass().getName());

		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
