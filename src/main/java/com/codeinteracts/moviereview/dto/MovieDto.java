package com.codeinteracts.moviereview.dto;

import java.math.BigDecimal;

public class MovieDto {

	private Long id;

	private String name;

	private Float aggregatedRating;

	private BigDecimal budget;

	private String synopsis;

	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getAggregatedRating() {
		return aggregatedRating;
	}

	public void setAggregatedRating(Float aggregatedRating) {
		this.aggregatedRating = aggregatedRating;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
