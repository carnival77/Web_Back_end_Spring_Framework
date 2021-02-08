package myspring.movie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.movie.dao.mapper.MovieMapper;
import myspring.movie.vo.MovieVO;

@Repository
public class MovieDAOImpl implements IMovieDAO {

	@Autowired
	private MovieMapper movieMapper;

	public MovieDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public MovieVO getMovie(String title) {
		// TODO Auto-generated method stub
		return movieMapper.selectMovieByMovietitle(title);
	}

	@Override
	public List<MovieVO> getMovies() {
		// TODO Auto-generated method stub
		return movieMapper.selectMovieList();
	}

	@Override
	public int insertMovie(MovieVO movie) {
		// TODO Auto-generated method stub
		return movieMapper.insertMovie(movie);
	}

	@Override
	public int updateMovie(MovieVO movie) {
		// TODO Auto-generated method stub
		return movieMapper.updateMovie(movie);
	}

	@Override
	public int deleteMovie(int id) {
		// TODO Auto-generated method stub
		return movieMapper.deleteMovie(id);
	}

}
