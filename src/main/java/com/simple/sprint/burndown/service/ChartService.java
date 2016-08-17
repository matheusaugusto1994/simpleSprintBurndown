package com.simple.sprint.burndown.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simple.sprint.burndown.model.Burndown;
import com.simple.sprint.burndown.model.TasksDay;
import com.simple.sprint.burndown.repository.BurndownRepository;
import com.simple.sprint.burndown.repository.TasksDayRepository;

@Service
public class ChartService {

	private BurndownRepository burndownRepository;
	private TasksDayRepository tasksDayRepository;

	@Autowired
	public ChartService(BurndownRepository burndownRepository, TasksDayRepository tasksDayRepository) {
		this.burndownRepository = burndownRepository;
		this.tasksDayRepository = tasksDayRepository;
	}
	
	public Burndown getBurndownById(Long id) {
		return burndownRepository.findOne(id);
	}

	public void addTasksDay(TasksDay tasksday) {
		tasksday = tasksDayRepository.save(tasksday);
	}
	
}
