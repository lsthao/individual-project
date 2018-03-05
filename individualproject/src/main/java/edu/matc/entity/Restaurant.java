package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Restaurant")
@Table(name="Restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    int id;

    @Column(name="name")
    String name;

    @Column(name="location")
    String location;

    @Column(name="phone_number")
    String phoneNumber;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Picture> pictures = new HashSet<>();

    public Restaurant() {

    }

    public Restaurant(String name, String location, String phoneNumber) {

        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public void addPicture(Picture picture) {
        pictures.add(picture);
        picture.setRestaurant(this);
    }

    public void removePicture(Picture picture) {
        pictures.remove(picture);
        picture.setRestaurant(null);
    }


}
