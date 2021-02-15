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

import myspring.movie.dao.IMovieDAO;
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

	@Autowired
	IMovieDAO dao;

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
	public void mapper_selectOne() {
		MovieVO movie = mapper.selectMovieByMovietitle("올드보이");
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
	@Ignore
	public void mapper_insert() {
		MovieVO movie = new MovieVO("Test", "action", "dd", 160);
		int result = mapper.insertMovie(movie);
		System.out.println((result == 1) ? "insert 성공" : "insert 실패");
	}

	@Test
	@Ignore
	public void mapper_delete() {
		int result = mapper.deleteMovie(4);
		System.out.println((result == 1) ? "delete 성공" : "delete 실패");
	}

	@Test
	@Ignore
	public void mapper_update() {
		MovieVO movie = new MovieVO("BreakingDawn", "action", "who?", 300);
		mapper.updateMovie(movie);
		System.out.println(mapper.selectMovieByMovietitle("BreakingDawn"));
	}

	@Test
	@Ignore
	public void dao() {
//		MovieVO movie = dao.getMovie("BreakingDawn");
		List<MovieVO> movies = dao.getMovies();
		System.out.println(movies);
	}

}
