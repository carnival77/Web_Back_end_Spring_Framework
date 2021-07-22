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
	
	//����
	@PutMapping("/users")
	public int updateUser(@RequestBody UserVO user) {
		return dao.updateUser(user);
	}
	
	//���
	@PostMapping("/users")
	public int insertUser(@RequestBody UserVO user) {
		return dao.insertUser(user);
	}
	
	
	//1�� ��ȸ
	@GetMapping("/users/{userid}")
	public UserVO getUser(@PathVariable String userid) {
		return dao.getUser(userid);
	}
	
	//�����ȸ
	@GetMapping("/users")
	public List<UserVO> users() {
		return dao.getUsers();
	}
}
