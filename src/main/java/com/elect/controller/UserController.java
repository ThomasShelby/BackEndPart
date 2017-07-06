package com.elect.controller;

import com.elect.model.User;
import com.elect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    //	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public List<User> listUsers() {
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

    @RequestMapping(value = "/email/{email:.+}", method = RequestMethod.GET)
    public ResponseEntity getUserByEmail(@PathVariable(value = "email") String email) {

        User user = userService.findUserByEmail(email);
        if (user == null) {
            return new ResponseEntity("No User found for Email " + email, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        /**
         * Preferred way to achieve uniqueness of field [email] should be implementing custom @Unique annotation
         * and applying it on field [email] of Model class [User].
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         *
         */
        if (!userService.isUserEmailUnique(user.getId(), user.getEmail())) {
            FieldError ssnError = new FieldError("user", "email",
                    messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        return "success";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit/{email}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String email, ModelMap model) {
        User user = userService.findUserByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit/{email}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String email) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.isUserEmailUnique(user.getId(), user.getEmail())) {
            FieldError emailError = new FieldError("user", "email",
                    messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
            result.addError(emailError);
            return "registration";
        }

        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete/{userId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return "redirect:/users";
    }
}
