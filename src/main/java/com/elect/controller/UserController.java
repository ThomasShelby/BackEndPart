package com.elect.controller;

import com.elect.model.User;
import com.elect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserById(@PathVariable(value = "id") int id) {

        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

//    @RequestMapping(value = "/email={email}", method = RequestMethod.GET)
//    public ResponseEntity getUserByEmail(@PathVariable(value = "email") String email) {
//
//        User user = userService.findUserByEmail(email);
//        if (user == null) {
//            return new ResponseEntity("No User found for Email " + email, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity(user, HttpStatus.OK);
//    }
}
