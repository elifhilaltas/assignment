package com.assignment.bsp.controller;

import com.assignment.bsp.domain.Authorities;
import com.assignment.bsp.domain.Users;
import com.assignment.bsp.service.AuthorityService;
import com.assignment.bsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class AssignmentController {

	@Autowired
	UserService userService;

	@Autowired
	AuthorityService authorityService;

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


	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new Users());
		mav.addObject("role", new Authorities());

		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST )
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
								@ModelAttribute("user") Users user,@ModelAttribute("role") Authorities role, Errors errors) {

		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
			return new ModelAndView("registerFail");

		}
		else {
			userService.add(user);
			authorityService.add(role);
			return new ModelAndView("welcome", "firstname", user.getName());
		}



	}


}






