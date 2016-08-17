package com.simple.sprint.burndown.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="tasks_day")
public class TasksDay {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "burndown_id")
	@JsonBackReference
	private Burndown burndown;
	
	@Column(name="day_number")
	private Integer dayNumber;
	
	@Column(name="remaining_Tasks")
	private Integer remainingTasks;
	
	public TasksDay() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Burndown getBurndown() {
		return burndown;
	}

	public void setBurndown(Burndown burndown) {
		this.burndown = burndown;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public Integer getRemainingTasks() {
		return remainingTasks;
	}

	public void setRemainingTasks(Integer remainingTasks) {
		this.remainingTasks = remainingTasks;
	}
	
	
}
