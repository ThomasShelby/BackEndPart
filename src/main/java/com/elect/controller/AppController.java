package com.elect.controller;

import com.elect.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@RestController
public class AppController {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	UserService userService;
	
	@Autowired
    MessageSource messageSource;

	@RequestMapping("/")
	public String welcome() {
		LOG.debug("welcome() method is being executed inside AppController..");
		return "Welcome to Elect Rest Service.";
	}
}
