package notice.controller;

import java.sql.Timestamp;
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

//import movie.vo.MovieVO;
import notice.dao.NoticeDAO;
import notice.vo.NoticeVO;

@Controller
@RequestMapping("/*")
public class NoticeController {
	
	int cnt=0;
	
	@Autowired
	private NoticeDAO dao;

	public NoticeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@GetMapping("list")
	@GetMapping("list")
	public ModelAndView noticeList() {
		List<NoticeVO> noticelist = dao.getNotices();
		return new ModelAndView("list", "notices", noticelist);
	}
	
	@GetMapping("write")
	public String noticeInsertForm() {
		return "writeForm";
	}
	
	@PostMapping("write")
	public String noticeInsert(@ModelAttribute NoticeVO noticeVO) {
		//@ModelAttribute는 객체를 파라미터로 받음
		int cnt = dao.insertNotice(noticeVO);
		if(cnt==1) {
			return "redirect:/list";
		}else {
			return "redirect:/list";
		}
	}
	
	//파라미터가 있는 get
	@GetMapping("retrieve")
	public String noticeDetail(@RequestParam int no, Model model) {
		NoticeVO notice = dao.getNotice(no);
		cnt=cnt+1;
		notice.setReadcnt(notice.getReadcnt()+cnt);

		model.addAttribute("noticeOne", notice);
		return "retrieve";
	}
	
	@GetMapping("/noticeDelete.do")
	public String movieDelete(@RequestParam int no) {
		int cnt = dao.deleteNotice(no);
		if (cnt == 1) {
			return "redirect:/list";
		} else {
			return "redirect:/list";
		}
	}
	
	@GetMapping("/noticeUpdate.do")
	public ModelAndView movieUpdateForm(@RequestParam int no) {
//		int[] runningtimeList = { 100, 200, 300 };
		NoticeVO notice = dao.getNotice(no);

//		Map<String, Object> dataMap = new HashMap<String, Object>();
//		dataMap.put("movie", movie);
//		dataMap.put("runningtimes", runningtimeList);
		return new ModelAndView("movieUpdate", "movie", notice);
	}
	
	@PostMapping("update")
	public String noticeUpdate(@ModelAttribute NoticeVO notice) {
		int cnt = dao.updateNotice(notice);
		if (cnt == 1) {
			return "redirect:/list";
		} else {
			return "redirect:/list";
		}
	}
	
}
