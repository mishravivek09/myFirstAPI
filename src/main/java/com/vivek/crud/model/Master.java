package com.vivek.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="master")
public class Master {
	private long id;
	private String name;
	private long year;
	private double rating;
	private String imgUrl;
	private String url;
	public Master(String name, long year, double rating, String imgUrl, String url) {
		super();
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.imgUrl = imgUrl;
		this.url = url;
	}
	public Master() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	@Column(name = "master_name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "master_year", nullable = false)
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	@Column(name = "master_rating", nullable = false)
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Column(name = "master_img", nullable = false)
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Column(name = "master_url", nullable = false)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Master [id=" + id + ", name=" + name + ", year=" + year + ", rating=" + rating + ", imgUrl=" + imgUrl
				+ ", url=" + url + "]";
	}
	
}
