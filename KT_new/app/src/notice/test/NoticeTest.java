//package notice.test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import notice.dao.NoticeDAO;
//import notice.dao.mapper.NoticeMapper;
//import notice.vo.NoticeVO;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:config/springbeans.xml")
//public class NoticeTest {
//	@Autowired
//	DataSource dataSource;
//	
//	@Autowired
//	SqlSessionFactory factory;
//	
//	@Autowired
//	SqlSession session;
//	
//	@Autowired
//	NoticeMapper mapper;
//	
//	@Autowired
//	NoticeDAO dao;
//	
//	
//	@Test
//	@Ignore
//	public void ds() {
//		try {
//			Connection connection = dataSource.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	@Ignore
//	public void mapper_selectOne() {
//		NoticeVO notice=mapper.selectNoticeByTitle("배송관련");
//		System.out.println(notice);
//	}
//	
//	@Test
//	public void dao() {
//		List<NoticeVO> notices = dao.getNotices();
//		System.out.println(notices);
//	}
//	
//}
