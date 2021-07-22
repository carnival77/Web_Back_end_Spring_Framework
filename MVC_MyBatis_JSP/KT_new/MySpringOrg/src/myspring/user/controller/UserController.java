package myspring.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.dao.IUserDAO;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private IUserDAO dao;
	
	public UserController() {
		System.out.println("UserController ������ ȣ���");
	}
	
	@GetMapping("/userDelete.do/{id}")
	public String userDelete(@PathVariable int id) {
		int cnt = dao.deleteUser(id);
		if (cnt == 1) 
			return "redirect:/userList.do";
		else 
			return "redirect:/";
	}
	
	
	
	@PostMapping("/userUpdate.do")
	public String userUpdate(@ModelAttribute UserVO user) {
		System.out.println("���������� ���޹��� UserVO " + user);
		int cnt = dao.updateUser(user);
		if (cnt == 1) 
			return "redirect:/userDetail.do?userid="+user.getUserid();
		else
			return "redirect:/";
	}
	
	
	
	@GetMapping("/userUpdate.do")
	public ModelAndView userUpdateForm(@RequestParam String userid) {
		List<String> cityList = List.of("����","���","�λ�","�뱸","����");
		UserVO user = dao.getUser(userid);
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("user", user);
		dataMap.put("cities",cityList);
		
		return new ModelAndView("userUpdate", "map", dataMap);
	}
	
	
	@PostMapping("/userInsert.do")
	public String userInsert(@ModelAttribute UserVO userVO) {
		int cnt = dao.insertUser(userVO);
		if (cnt == 1) return "redirect:/userList.do";
		else return "redirect:/";
	}
	
	
	
	@GetMapping("/userInsert.do")
	public String userInsertForm(Model model) {
		List<String> cityList = List.of("����","���","�λ�","�뱸","����");
		model.addAttribute("cities", cityList);
		return "userInsert";
	}
	
	
	
	@GetMapping("/userDetail.do")
	public String userDetail(@RequestParam String userid, Model model) {
		UserVO user = dao.getUser(userid);
		model.addAttribute("userOne", user);
		return "userDetail";
	}
	
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = dao.getUsers();
		return new ModelAndView("userList", "users", userList);
	}
	
	
	
}
