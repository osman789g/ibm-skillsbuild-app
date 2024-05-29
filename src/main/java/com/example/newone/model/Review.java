package com.example.newone.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String coursenames;

    private String comment;

    private int rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoursenames() {
        return coursenames;
    }

    public void setCoursenames(String coursenames) {
        this.coursenames = coursenames;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}