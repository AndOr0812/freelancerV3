package com.freelancer.server.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelancer.server.model.Project;
import com.freelancer.server.model.ProjectBidDetails;
import com.freelancer.server.repository.ProjectRepository;
import com.freelancer.server.service.AggregateResults;
import com.freelancer.server.service.projectData;
import com.freelancer.server.repository.ProjectDetailRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ProjectDetailRepository projectDetailRepository;
	
	@CrossOrigin
	@GetMapping("/")
	public String projectHome() {
		return "This is the project main route";
	}
	
	@CrossOrigin
	@PostMapping("/new")
	public Project addProject(@RequestBody Project project) {
		System.out.println("Inside the new project route");
		//System.out.println(jsonString);
		try {
			//JSONObject projObj = new JSONObject(jsonString);
		return projectRepository.save(project);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Project> getAllProjects(){
		System.out.println("Get All project route");
		return projectRepository.findAllOpenProjects();
	}
	
	@CrossOrigin
	@GetMapping(path="/{projectid}")
	public ResponseEntity<String> getProjectDetail(@PathVariable("projectid") Long ProjectId) throws Exception{
		System.out.println("Inside the get project detail route");
		Optional<Project> project = projectRepository.findById(ProjectId);
		List<ProjectBidDetails> projectBidDetails= projectDetailRepository.findAllProjectDetails(ProjectId);
		AggregateResults average_bid = projectDetailRepository.findAverageBybid_amount(ProjectId);		
		return new ResponseEntity( new projectData( project, projectBidDetails,average_bid ), HttpStatus.OK );
	}
}
