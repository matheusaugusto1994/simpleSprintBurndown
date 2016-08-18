package com.simple.sprint.burndown.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@RequestMapping("/")
	public ModelAndView init(HttpSession session){
		
		//TODO ALTER HERE ADD INTERCEPTOR
		
		return new ModelAndView("burndown");
	}
	
}
