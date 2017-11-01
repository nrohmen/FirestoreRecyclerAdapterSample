package com.guidoapps.firestorerecycleradaptersample;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class FriendsResponse {
    private String name;
    private String title;
    private String company;
    private String image;

    public FriendsResponse() {
    }

    public FriendsResponse(String name, String title, String company, String image) {
        this.name = name;
        this.title = title;
        this.company = company;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
