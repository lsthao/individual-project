package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="Picture")
@Table(name="Pictures")
public class Picture {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name="Picture")
    private String picture;

    @Column(name="comment")
    private String comment;

    @ManyToOne
    private Restaurant restaurant;

    @Column(name="user_id")
    private int userID;

    public Picture() {

    }

    public Picture(String picture, Restaurant restaurant, int userID) {
        this.picture = picture;
        this.restaurant = restaurant;
        this.userID=userID;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
