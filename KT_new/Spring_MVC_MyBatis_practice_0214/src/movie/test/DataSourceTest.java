package movie.test;

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

import movie.dao.MovieDao;
import movie.dao.mapper.MovieMapper;
import movie.vo.MovieVO;

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
	MovieMapper mapper;
	
	@Autowired
	MovieDao dao;
	
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
	
	@Test
	@Ignore
	public void mapper_selectOne() {
		MovieVO movie=mapper.selectMovieByMovietitle("올드보이");
		System.out.println(movie);
	}
	
	@Test
	public void dao() {
		List<MovieVO> movies = dao.getMovies();
		System.out.println(movies);
	}
	
}
