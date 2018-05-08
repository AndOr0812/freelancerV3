package com.freelancer.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bids")
@NamedQuery(name = "ProjectBidDetails.findAllProjectDetails",
query = "SELECT b FROM ProjectBidDetails b WHERE b.proj_id = :projectid"
)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt","updatedAt"},
allowGetters = true)
public class ProjectBidDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private Long proj_id;
	
	@NotBlank
	private Long bid_userid;
	
	@NotBlank
	private String bid_username;
	
	@NotBlank
	private float bid_amount;
	
	@NotBlank
	private int bid_period;
	
	@NotBlank
	private String bid_status;
	
	@NotBlank
	private Long employer;
	
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

	public Long getProj_id() {
		return proj_id;
	}

	public void setProj_id(Long proj_id) {
		this.proj_id = proj_id;
	}

	public Long getBid_userid() {
		return bid_userid;
	}

	public void setBid_userid(Long bid_userid) {
		this.bid_userid = bid_userid;
	}

	public String getBid_username() {
		return bid_username;
	}

	public void setBid_username(String bid_username) {
		this.bid_username = bid_username;
	}

	public float getBid_amount() {
		return bid_amount;
	}

	public void setBid_amount(float bid_amount) {
		this.bid_amount = bid_amount;
	}

	public int getBid_period() {
		return bid_period;
	}

	public void setBid_period(int bid_period) {
		this.bid_period = bid_period;
	}

	public String getBid_status() {
		return bid_status;
	}

	public void setBid_status(String bid_status) {
		this.bid_status = bid_status;
	}

	public Long getEmployer() {
		return employer;
	}

	public void setEmployer(Long employer) {
		this.employer = employer;
	}
}
