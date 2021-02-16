package myspring.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.movie.dao.IMovieDAO;
import myspring.movie.vo.MovieVO;

@Controller
public class MovieController {
	@Autowired
	private IMovieDAO dao;

	public MovieController() {
		super();
		System.out.println("Movie 컨트롤러 생성자 호출");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("movieList.do")
	public ModelAndView movieList() {
		List<MovieVO> movieList = dao.getMovies();
		return new ModelAndView("movieList", "movies", movieList);
	}

	@GetMapping("/movieDetail.do")
	public String movieDetail(@RequestParam String title, Model model) {
		MovieVO movie = dao.getMovie(title);

		model.addAttribute("movieOne", movie);
		return "movieDetail";
	}

	@GetMapping("/movieDelete.do")
	public String movieDelete(@RequestParam int id) {
		int cnt = dao.deleteMovie(id);
		if (cnt == 1) {
			return "redirect:/movieList.do";
		} else {
			return "redirect:/";
		}

	}

	@PostMapping("/movieInsert.do")
	public String movieInsert(@ModelAttribute MovieVO movieVO) {
		
		int cnt = dao.insertMovie(movieVO);
		if (cnt == 1) {
			return "redirect:/movieList.do";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/movieInsert.do")
	public String movieInsertForm(Model model) {
		List<Integer> runningtimeList = List.of(100, 200, 300);
		model.addAttribute("runningtimes", runningtimeList);
		return "movieInsert";
	}

	@GetMapping("/movieUpdate.do")
	public ModelAndView movieUpdateForm(@RequestParam String title) {
		int[] runningtimeList = {100,200,300};
		MovieVO movie = dao.getMovie(title);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("movie", movie);
		dataMap.put("runningtimes", runningtimeList);
		return new ModelAndView("movieUpdate", "movie", dataMap);
	}

	@PostMapping
	public String movieUpdate(@ModelAttribute MovieVO movie) {
		int cnt = dao.updateMovie(movie);
		if (cnt == 1) {
			return "redirect:/movieDetail.do?title=" + movie.getTitle();
		} else {
			return "redirect:/";
		}
	}

}
