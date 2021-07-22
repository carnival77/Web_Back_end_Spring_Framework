package myspring.user.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.mapper.StudentMapper;
import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring-beans.xml")
public class MyBatisTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	StudentMapper stuMapper;
	
	@Autowired
	UserService service;
	
	@Test
	public void service() {
//		new UserVO("spring", "스프링변경","여" , "제주");
		UserVO user =  service.getUser("spring");
		System.out.println("변경전" + user);
		
		service.updateUser(new UserVO("spring", "스프링변경","여" , "제주"));
		
		user =  service.getUser("spring");
		System.out.println("변경후" + user);
	}
	
	@Test
	@Ignore
	public void stu_status() {
		StudentVO student = stuMapper.selectStudentCourseStatus(1002);
		System.out.println(student);
	}
	
	@Test @Ignore
	public void stu_dept() {
		StudentVO student = stuMapper.selectStudentDept(1002);
		System.out.println(student);
	}
	
	@Test
	@Ignore
	public void list() {
		List<UserVO> userList = userMapper.selectUserList();
		userList.forEach(user -> System.out.println(user));
	}
	
	
	@Test
	@Ignore
	public void insert_list() {
		UserVO userVO = new UserVO("spring","스프링","남","경기");
		int cnt = sqlSession.insert("userNS.insertUser",userVO);
		System.out.println(cnt);
	}

	@Test
	@Ignore
	public void selectOne() {
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void conn() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
			System.out.println(metaData.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
