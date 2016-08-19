package com.simple.sprint.burndown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simple.sprint.burndown.model.Burndown;
import com.simple.sprint.burndown.model.TasksDay;
import com.simple.sprint.burndown.service.BurndownService;

@RestController
public class ChartController{
	
	@Autowired
	private BurndownService burndownService;

	@RequestMapping(value="/chart/{id}", method={RequestMethod.GET})
	public ModelAndView init(@PathVariable Long id){
		return new ModelAndView("chart");
	}

	@RequestMapping(value="/chart/load/{id}", method={RequestMethod.GET})
	public @ResponseBody Burndown load(@PathVariable Long id){
		return burndownService.getBurndownById(id);
	}

	@RequestMapping(value="/chart/send", method={RequestMethod.POST})
	public @ResponseBody Burndown send(@RequestBody TasksDay tasksDay){
		return burndownService.addTasksDay(tasksDay);
	}
	
}
