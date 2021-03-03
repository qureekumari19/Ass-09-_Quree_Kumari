package com.app;

import java.util.Date;
import java.util.List;

public class Movies {
	private int movieId;
	private String movieName; 
	private String movieType;
	private String language; 
	private Date releaseDate; 
	private List<String> casting;
	private Double rating;
	private Double totalBusinessDone;
	public String toString()
	{
		return movieId+" "+movieName+" "+language+" "+releaseDate+" "+casting+" "+rating+" "+totalBusinessDone;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<String> getCasting() {
		return casting;
	}
	public void setCasting(List<String> casting) {
		this.casting = casting;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Double getTotalBusinessDone() {
		return totalBusinessDone;
	}
	public void setTotalBusinessDone(Double totalBusinessDone) {
		this.totalBusinessDone = totalBusinessDone;
	}	

}
