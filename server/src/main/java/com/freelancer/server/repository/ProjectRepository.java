package com.freelancer.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelancer.server.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
	
}
