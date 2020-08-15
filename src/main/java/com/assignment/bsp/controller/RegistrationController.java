package com.assignment.bsp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.bsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.assignment.bsp.domain.Users;
import com.assignment.bsp.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    public UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new Users());
        return mav;
    }
    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") Users user) {
        userRepository.register(user);
        return new ModelAndView("welcome", "firstname", user.getName());
    }
}
