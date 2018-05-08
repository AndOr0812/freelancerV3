package com.freelancer.server.controller;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelancer.server.model.Project;
import com.freelancer.server.repository.ProjectRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
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
	
	
}
