package com.aakash.treepathsum.controller;

import com.aakash.treepathsum.model.User;
import com.aakash.treepathsum.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Test
    public void registerValidUserTests(){
        User user = User.builder().email("aakash123@gmail.com").firstName("aakash").lastName("rad").password("password").build();

        ModelAndView modelAndView = new ModelAndView();
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        BindingResult bindingResult = mock(BindingResult.class);

        when(userService.findByEmail("aakash123@gmail.com")).thenReturn(null);
        doNothing().when(userService).registerUser(user);

        ModelAndView expectedMVC = userController.registerUser(modelAndView, user, httpServletRequest, bindingResult);

        Assert.assertEquals("register", expectedMVC.getViewName());

    }

    @Test
    public void registerEXistingUserTests(){
        User user = User.builder().email("aakash123@gmail.com").firstName("aakash").lastName("rad").password("password").build();
        ModelAndView modelAndView = new ModelAndView();
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        BindingResult bindingResult = mock(BindingResult.class);

        when(userService.findByEmail("aakash123@gmail.com")).thenReturn(user);

        ModelAndView expectedMVC = userController.registerUser(modelAndView, user, httpServletRequest, bindingResult);

        Assert.assertEquals("register", expectedMVC.getViewName());

    }
}
