package com.simple.sprint.burndown.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simple.sprint.burndown.model.Burndown;
import com.simple.sprint.burndown.service.BurndownService;

@RestController
public class BurndownController {

	private BurndownService burndownService;

	@Autowired
	public BurndownController(BurndownService burndownService) {
		this.burndownService = burndownService;
	}
	
	@RequestMapping("/burndown")
	public ModelAndView init(){
		return new ModelAndView("burndown");
	}
	
	@RequestMapping(value="/burndown/list", method={RequestMethod.GET})
	public @ResponseBody List<Burndown> list(){
		return burndownService.findAll();
	}
	
}
