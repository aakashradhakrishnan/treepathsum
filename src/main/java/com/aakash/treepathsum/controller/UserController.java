package com.aakash.treepathsum.controller;

import com.aakash.treepathsum.model.User;
import com.aakash.treepathsum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, User user, HttpServletRequest httpServletRequest, BindingResult bindingResult){

        User existingUser = userService.findByEmail(user.getEmail());

        if(existingUser==null) {
            userService.registerUser(user);
            modelAndView.addObject("confirmationMessage", "User has been added.");
            modelAndView.setViewName("register");
        }
        else{
            modelAndView.addObject("confirmationMessage", "User already exists");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }
        return modelAndView;
    }
}

