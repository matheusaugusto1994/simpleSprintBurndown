package com.simple.sprint.burndown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simple.sprint.burndown.model.Burndown;
import com.simple.sprint.burndown.model.TasksDay;
import com.simple.sprint.burndown.service.ChartService;

@RestController
public class ChartController{
	
	@Autowired
	private ChartService chartService;

	@RequestMapping(value="/", method={RequestMethod.GET})
	public ModelAndView init(){
		return new ModelAndView("chart");
	}

	@Transactional
	@RequestMapping(value="/chart/load", method={RequestMethod.GET})
	public @ResponseBody Burndown load(){
		return chartService.getBurndownById(1L);
	}

	@Transactional
	@RequestMapping(value="/chart/send", method={RequestMethod.POST})
	public @ResponseBody Burndown send(@RequestBody TasksDay tasksDay){
		chartService.addTasksDay(tasksDay);
		return chartService.getBurndownById(tasksDay.getBurndown().getId());
	}
	
}
