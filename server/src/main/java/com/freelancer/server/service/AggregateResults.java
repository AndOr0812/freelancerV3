package com.freelancer.server.service;

public class AggregateResults {
	private final double average_bid;

	private final int total_bids;

	public AggregateResults(Double average_bid, Long total_bids) {
	    this.average_bid = average_bid == null ? 0 : average_bid;
	    this.total_bids = total_bids == null ? 0 : total_bids.intValue();
	}
	
	public double getAverage_bid() {
		return average_bid;
	}

	public int getTotal_bids() {
		return total_bids;
	}
}
