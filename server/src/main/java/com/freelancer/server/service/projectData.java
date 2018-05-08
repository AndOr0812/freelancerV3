package com.freelancer.server.service;

import java.util.List;
import java.util.Optional;

import com.freelancer.server.model.Project;

import com.freelancer.server.model.ProjectBidDetails;
import com.freelancer.server.service.AggregateResults;

public class projectData {
	private final Optional<Project> project;
	private final List<ProjectBidDetails> projectBidDetails;
	private final AggregateResults average_bid;
	
	public projectData(Optional<Project> project,List<ProjectBidDetails> projectBidDetails,AggregateResults average_bid) {
		this.project = project;
		this.projectBidDetails = projectBidDetails;
		this.average_bid = average_bid;
	}
	
	public AggregateResults getAverage_bid() {
		return average_bid;
	}

	public Optional<Project> getProject() {
		return project;
	}

	public List<ProjectBidDetails> getProjectBidDetails() {
		return projectBidDetails;
	}

}
