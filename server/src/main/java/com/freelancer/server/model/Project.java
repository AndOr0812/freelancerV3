package com.freelancer.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="projects")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt","updatedAt"},
allowGetters = true)
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String proj_name;
	
	private String proj_desc;
	private String proj_skills;
	private String budget_currency;
	private String proj_budget;
	private String proj_status;
	
	@NotBlank
	private String employer;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getProj_desc() {
		return proj_desc;
	}
	public void setProj_desc(String proj_desc) {
		this.proj_desc = proj_desc;
	}
	public String getproj_skills() {
		return proj_skills;
	}
	public void setproj_skills(String proj_skills) {
		this.proj_skills = proj_skills;
	}
	public String getBudget_currency() {
		return budget_currency;
	}
	public void setBudget_currency(String budget_currency) {
		this.budget_currency = budget_currency;
	}
	public String getproj_budget() {
		return proj_budget;
	}
	public void setproj_budget(String proj_budget) {
		this.proj_budget = proj_budget;
	}
	public String getproj_status() {
		return proj_status;
	}
	public void setproj_status(String proj_status) {
		this.proj_status = proj_status;
	}
	public String getemployer() {
		return employer;
	}
	public void setemployer(String employer) {
		this.employer = employer;
	}	
}
