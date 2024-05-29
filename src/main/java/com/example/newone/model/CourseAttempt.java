package com.example.newone.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CourseAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int userId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Courses courseId;
    private String courseName;


    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private long durationInSeconds;

    public CourseAttempt(int userid, String courseName, LocalDateTime startTime, LocalDateTime finishTime, long durationinseconds) //Why is this here?
    {
        this.userId = userid;
        this.courseName = courseName;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.durationInSeconds = durationinseconds;
    }


    public CourseAttempt() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userid) {
        this.userId = userid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
        Duration duration = Duration.between(this.startTime, finishTime);
        this.durationInSeconds = duration.getSeconds();
    }

    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public void setCourseLink(String courselink) {
    }
}
