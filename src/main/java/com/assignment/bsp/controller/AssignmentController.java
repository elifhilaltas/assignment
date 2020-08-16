package com.assignment.bsp.controller;

import com.assignment.bsp.domain.Users;
import com.assignment.bsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class AssignmentController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
		
	}
	
	@RequestMapping(value = { "/","/index.html"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

/*
	@RequestMapping(value = "/register.html" , method = RequestMethod.GET)
	public ModelAndView register(Users user) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}

 */

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new Users());
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST )
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
								@ModelAttribute("user") Users user) {
		userService.add(user);
		return new ModelAndView("welcome", "firstname", user.getName());
	}
	}






