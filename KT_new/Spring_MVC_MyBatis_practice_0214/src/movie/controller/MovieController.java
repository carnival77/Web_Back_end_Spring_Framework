package movie.controller;

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

import movie.dao.MovieDao;
import movie.vo.MovieVO;

@Controller
public class MovieController {
	@Autowired
	private MovieDao dao;

	public MovieController() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameter가 없는 get
//	@RequestMapping("movieList.do")
	@GetMapping("movieList.do")
	public ModelAndView movieList() {
		List<MovieVO> movielist = dao.getMovies();
		return new ModelAndView("movieList", "movies", movielist);
	}

	//파라미터가 있는 get
	@GetMapping("/movieDetail.do")
	public String movieDetail(@RequestParam String title, Model model) {
		MovieVO movie = dao.getMovie(title);

		model.addAttribute("movieOne", movie);
		return "movieDetail";
	}

//	@GetMapping("/movieDetail.do")
//	public ModelAndView movieDetail(@RequestParam String title, Model model) {
//		MovieVO movie = dao.getMovie(title);
//
//		return new ModelAndView("movieDetail", "movieOne", movie);
//	}

	@GetMapping("/movieDelete.do")
	public String movieDelete(@RequestParam int id) {
		int cnt = dao.deleteMovie(id);
		if (cnt == 1) {
			return "redirect:/movieList.do";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/movieUpdate.do")
	public ModelAndView movieUpdateForm(@RequestParam String title) {
		int[] runningtimeList = { 100, 200, 300 };
		MovieVO movie = dao.getMovie(title);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("movie", movie);
		dataMap.put("runningtimes", runningtimeList);
		return new ModelAndView("movieUpdate", "movie", dataMap);
	}
	
	@GetMapping("/movieInsert.do")
	public ModelAndView movieInsertForm() {
		List<Integer> runningtimeList = List.of(100, 200, 300);
		return new ModelAndView("movieInsert", "runningtimes", runningtimeList);
	}

	// 입력 정보를 보내는 post
	@PostMapping("/movieInsert.do")
	public String movieInsert(@ModelAttribute MovieVO movieVO) {
		//@ModelAttribute는 객체를 파라미터로 받음
		int cnt = dao.insertMovie(movieVO);
		if(cnt==1) {
			return "redirect:/movieList.do";
		}else {
			return "redirect:/";
		}
	}
}
