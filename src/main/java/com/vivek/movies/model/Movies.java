package com.vivek.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="movies")
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name ="movie_name")
	private String movieName;
	@Column(name ="movie_image")
	private String movieImage;
	@Column(name ="movie_url")
	private String movieUrl;
	@Column(name ="movie_year")
	private long movieYear;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}
	public String getMovieUrl() {
		return movieUrl;
	}
	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}
	public long getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(long movieYear) {
		this.movieYear = movieYear;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Movies(long id, String movieName, String movieImage, String movieUrl, long movieYear) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieImage = movieImage;
		this.movieUrl = movieUrl;
		this.movieYear = movieYear;
	}
	public Movies() {
		super();
	}
	
}
