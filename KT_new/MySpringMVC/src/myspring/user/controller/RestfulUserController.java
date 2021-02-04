package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.dao.IUserDAO;
import myspring.user.vo.UserVO;

@RestController
public class RestfulUserController {

	@Autowired
	private IUserDAO dao;

	@DeleteMapping("/users/{id}")
	public int deleteUser(@PathVariable int id) {
		return dao.deleteUser(id);
	}

	// 수정
	@PutMapping("/users")
	public int updateUser(@RequestBody UserVO user) {
		return dao.updateUser(user);
	}

	// 등록
	@PostMapping("/users")
	public int insertUser(@RequestBody UserVO user) {
		return dao.insertUser(user);
	}

	// 1개 조회
	@GetMapping("/users/{userid}")
	public UserVO getUser(@PathVariable String userid) {
		return dao.getUser(userid);
	}

	// 목록 조회
	@GetMapping("/users")
	public List<UserVO> users() {
		return dao.getUsers();
	}
	
	@GetMapping("/cities")
	public List<String> cityList() {
		return List.of("서울", "경기", "부산", "대구");
	}

}
