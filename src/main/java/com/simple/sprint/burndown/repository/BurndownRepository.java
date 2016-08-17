package com.simple.sprint.burndown.repository;

import org.springframework.data.repository.CrudRepository;

import com.simple.sprint.burndown.model.Burndown;

public interface BurndownRepository extends CrudRepository<Burndown, Long> {

}
