package com.freelancer.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freelancer.server.model.ProjectBidDetails;
import com.freelancer.server.service.AggregateResults;

@Repository
public interface ProjectDetailRepository  extends JpaRepository<ProjectBidDetails,Long> {
	public List<ProjectBidDetails> findAllProjectDetails(@Param("projectid") Long projectid);
	
	@Query("SELECT new com.freelancer.server.service.AggregateResults(AVG(bid_amount) as average_bid,COUNT(bid_amount) as total_bids) from ProjectBidDetails where proj_id=:projectid")
	public AggregateResults findAverageBybid_amount(@Param("projectid") Long projectid);

	@Query("SELECT t from ProjectBidDetails t where t.bid_userid=:bid_userid")
	public List<ProjectBidDetails> findMyBids(@Param("bid_userid") Long bid_userid);
}
