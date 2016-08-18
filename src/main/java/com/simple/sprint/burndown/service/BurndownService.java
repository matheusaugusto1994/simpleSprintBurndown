package com.simple.sprint.burndown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simple.sprint.burndown.model.Burndown;
import com.simple.sprint.burndown.model.TasksDay;
import com.simple.sprint.burndown.repository.BurndownRepository;

@Service
public class BurndownService {

	private BurndownRepository burndownRepository;

	@Autowired
	public BurndownService(BurndownRepository burndownRepository) {
		this.burndownRepository = burndownRepository;
	}
	
	@Transactional
	public Burndown getBurndownById(Long id) {
		return burndownRepository.findOne(id);
	}

	@Transactional
	public Burndown addTasksDay(TasksDay tasksday) {
		Burndown burndown = getBurndownById(tasksday.getBurndown().getId());
		burndown.getTasksdays().add(tasksday);
		return burndownRepository.saveAndFlush(burndown);
	}

	@Transactional
	public List<Burndown> findAll() {
		return burndownRepository.findAll();
	}
	
}
