package com.simple.sprint.burndown.repository;

import org.springframework.data.repository.CrudRepository;

import com.simple.sprint.burndown.model.TasksDay;

public interface TasksDayRepository extends CrudRepository<TasksDay, Long> {

}
