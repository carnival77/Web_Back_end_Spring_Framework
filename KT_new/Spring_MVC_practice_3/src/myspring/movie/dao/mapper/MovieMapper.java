package myspring.movie.dao.mapper;

import java.util.List;

import myspring.movie.vo.MovieVO;

public interface MovieMapper {
	MovieVO selectMovieByMovietitle(String title);

	List<MovieVO> selectMovieList();

	int insertMovie(MovieVO movie);

	int updateMovie(MovieVO movie);

	int deleteMovie(String title);
}
