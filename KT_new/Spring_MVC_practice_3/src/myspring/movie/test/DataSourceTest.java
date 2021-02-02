package myspring.movie.test;

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

import myspring.movie.dao.mapper.MovieMapper;
import myspring.movie.vo.MovieVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/springbeans.xml")
public class DataSourceTest {
	@Autowired
	DataSource dataSource;
//	
	@Autowired
	SqlSessionFactory factory;

	@Autowired
	SqlSession session;

	@Autowired
	MovieMapper mapper;

	@Test
	@Ignore
	public void ds() {
		try {
			Connection connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void mapper_selectOne() {
		MovieVO movie = mapper.selectMovieByMovietitle("¹Ì³ª¸®");
		System.out.println(movie);
	}

	@Test
	@Ignore
	public void mapper_selectAll() {
		List<MovieVO> movies = mapper.selectMovieList();
		for (MovieVO movieVO : movies) {
			System.out.println(movieVO);
		}
	}
	
	@Test
	

}
