package com.example.newone.model;


import javax.persistence.*;
import java.time.LocalDate;

// This entity acts as a join table between UserEntity and Badge (ManyToMany relationship)
@Entity
public class User_Badge {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "badgeId")
    private Badge badge;

    private LocalDate dateEarned;

    public User_Badge(UserEntity user, Badge badge, LocalDate dateEarned) {
        this.user = user;
        this.badge = badge;
        this.dateEarned = dateEarned;
    }

    public User_Badge() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public LocalDate getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(LocalDate dateEarned) {
        this.dateEarned = dateEarned;
    }
}
