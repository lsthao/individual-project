package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Pictures")
public class Picture {

    @Id
    @Column(name="PictureID")
    private int pictureID;

    @Column(name="Picture")
    private String picture;

    @Column(name="RestaurantID")
    private int restaurantID;

    @Column(name="Username")
    private String username;

    public Picture() {

    }

    public Picture(int pictureID, String picture, int restaurantID, String username) {
        this.pictureID = pictureID;
        this.picture = picture;
        this.restaurantID = restaurantID;
        this.username = username;

    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
