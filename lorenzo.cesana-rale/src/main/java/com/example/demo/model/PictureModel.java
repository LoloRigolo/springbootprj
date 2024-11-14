package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PictureModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String photographer;
	private Date releaseDate;
	private String status;
	
	public PictureModel(String title, String photographer, Date releaseDate, String status) {
		this.title = title;
		this.photographer = photographer;
		this.releaseDate = releaseDate;
		this.status = status;
	}
	
	public PictureModel() {}
	
	public Long getId() {
        return id;
    }
    
	public void setId(long l) {
		this.id = l;
	}
	
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
