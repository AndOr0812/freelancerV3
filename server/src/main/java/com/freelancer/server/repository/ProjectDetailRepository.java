package com.freelancer.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freelancer.server.model.ProjectBidDetails;

@Repository
public interface ProjectDetailRepository  extends JpaRepository<ProjectBidDetails,Long> {
	public List<ProjectBidDetails> findAllProjectDetails(@Param("projectid") Long projectid);

}
