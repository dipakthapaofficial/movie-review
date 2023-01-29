package com.codeinteracts.moviereview.entity;

import java.io.Serializable;

public class MovieReview implements Serializable {
	
	private static final long serialVersionUID = 3432576057132447714L;

//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="movie_review")
    private User user;

    private String comment;
    
//    @ColumnDefault("true")
    private Boolean active;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
    
    

}
