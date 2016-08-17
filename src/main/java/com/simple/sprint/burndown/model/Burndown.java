package com.simple.sprint.burndown.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Burndown {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="number_days")
	private Integer numberDays;

	@Column(name="number_tasks")
	private Integer numberTasks;
	
	@OneToMany(mappedBy="burndown", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<TasksDay> tasksdays;
	
	public Burndown() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberDays() {
		return numberDays;
	}

	public void setNumberDays(Integer numberDays) {
		this.numberDays = numberDays;
	}

	public Integer getNumberTasks() {
		return numberTasks;
	}

	public void setNumberTasks(Integer numberTasks) {
		this.numberTasks = numberTasks;
	}

	public List<TasksDay> getTasksdays() {
		return tasksdays;
	}

	public void setTasksdays(List<TasksDay> tasksdays) {
		this.tasksdays = tasksdays;
	}
	
	
}
