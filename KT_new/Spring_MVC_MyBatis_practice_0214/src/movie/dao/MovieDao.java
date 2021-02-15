package movie.dao;

import java.util.List;

import movie.vo.MovieVO;

public interface MovieDao {
	MovieVO getMovie(String title);
	
	List<MovieVO> getMovies();
	
	int insertMovie(MovieVO movie);
	
	int updateMovie(MovieVO movie);
	
	int deleteMovie(int id);
}
