package com.codeinteracts.moviereview.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "MovieReview.findByMovie", 
			query = "SELECT mr FROM MovieReview mr WHERE mr.movie = ?1"), 
	@NamedQuery(name = "MovieReview.findByReviewer", 
			query = "SELECT mr FROM MovieReview mr WHERE mr.reviewer = ?1"), 
})
public class MovieReview implements Serializable {
	
	private static final long serialVersionUID = 3432576057132447714L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Movie movie;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reviewed_by")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User reviewer;

    private String review;
    
    @ColumnDefault("true")
    private Boolean active;
    
    private LocalDateTime createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
    

}
