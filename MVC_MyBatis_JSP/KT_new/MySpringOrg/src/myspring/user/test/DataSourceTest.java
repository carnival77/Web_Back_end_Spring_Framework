package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;

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
	
	@Test @Ignore
	public void mapper() {
		UserVO user = mapper.selectUserByUserid("gildong");
		System.out.println(user);
	}
	
	@Test //@Ignore
	public void dao() {
		UserVO user = dao.getUser("dooly");
		System.out.println(user);
	}
	
	
	@Test @Ignore
	public void sql() {
		UserVO user = session.selectOne("userNS.selectUserByUserid", "dooly");
		System.out.println(user);
	}
	
	
	@Test @Ignore
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
