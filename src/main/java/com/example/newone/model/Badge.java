package com.example.newone.model;

import javax.persistence.*;

@Entity
public class Badge {
    @Id
    private String badgeName;
    private String badgeDescription;
    private String imgUrl;

    public Badge(String badgeName, String badgeDescription, String imgUrl) {
        this.badgeName = badgeName;
        this.badgeDescription = badgeDescription;
        this.imgUrl = imgUrl;
    }

    public Badge() {}

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeDescription() {
        return badgeDescription;
    }

    public void setBadgeDescription(String badgeDescription) {
        this.badgeDescription = badgeDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
