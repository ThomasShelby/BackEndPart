package com.elect.controller;

import com.elect.model.User;
import com.elect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	UserService userService;

//	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
//	@GetMapping("/list")
	@RequestMapping(method = RequestMethod.GET)
	public List<User> listEmployees() {
		return userService.getAllUsers();
	}
}
