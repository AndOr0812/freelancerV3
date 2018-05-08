package com.freelancer.server.service;

import java.util.List;
import java.util.Optional;

import com.freelancer.server.model.Project;

import com.freelancer.server.model.ProjectBidDetails;

public class projectData {
	private final Optional<Project> project;
	private final List<ProjectBidDetails> projectBidDetails;
	
	public projectData(Optional<Project> project,List<ProjectBidDetails> projectBidDetails) {
		this.project = project;
		this.projectBidDetails = projectBidDetails;
	}
	
	public Optional<Project> getProject() {
		return project;
	}

	public List<ProjectBidDetails> getProjectBidDetails() {
		return projectBidDetails;
	}

}
