package com.elect.controller;

import com.elect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@RestController
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
    MessageSource messageSource;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Elect Rest Service.";
	}
}
