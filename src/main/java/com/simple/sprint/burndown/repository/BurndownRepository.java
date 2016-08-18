package com.simple.sprint.burndown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.sprint.burndown.model.Burndown;

public interface BurndownRepository extends JpaRepository<Burndown, Long> {

}
