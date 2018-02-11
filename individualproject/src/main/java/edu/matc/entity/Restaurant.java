package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Restaurants")
public class Restaurant {

    @Id
    @Column(name="RestaurantID")
    int restaurantID;

    @Column(name="RestaurantName")
    String restaurantName;

    @Column(name="RestaurantLocation")
    String restaurantLocation;

    public Restaurant() {

    }

    public Restaurant(int restaurantID, String restaurantName, String restaurantLocation) {

        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;

    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }




}
