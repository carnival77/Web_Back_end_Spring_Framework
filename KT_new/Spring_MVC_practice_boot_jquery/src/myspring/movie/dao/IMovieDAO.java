package myspring.movie.dao;

import java.util.List;

import myspring.movie.vo.MovieVO;

public interface IMovieDAO {
	MovieVO getMovie(String title);

	List<MovieVO> getMovies();

	int insertMovie(MovieVO movie);

	int updateMovie(MovieVO movie);

	int deleteMovie(int id);
}
