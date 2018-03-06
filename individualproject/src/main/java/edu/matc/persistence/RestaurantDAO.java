package edu.matc.persistence;

import edu.matc.entity.Restaurant;
import org.apache.log4j.Logger;
import org.hibernate.*;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get all restaurants
     */
    public List<Restaurant> getAllRestaurants() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = builder.createQuery(Restaurant.class);

        Root<Restaurant> root = query.from(Restaurant.class);
        List<Restaurant> restaurants = session.createQuery(query).getResultList();

        session.close();

        return restaurants;

    }

    /**
     * Get restaurant by ID
     * @param id id of restaurant
     */
    public Restaurant getRestaurantByID(int id) {
        Session session = sessionFactory.openSession();
        Restaurant restaurant = session.get(Restaurant.class, id);
        session.close();
        return restaurant;
    }

    /**
     * Update restaurant
     * @param restaurant restaurant to be updated
     */
    public void updateRestaurant(Restaurant restaurant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(restaurant);
        transaction.commit();
        session.close();
    }

    /**
     * Add a restaurant
     * @param restaurant restaurant to be added
     */

    public int addRestaurant(Restaurant restaurant) {
        int id = 0;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(restaurant);
        transaction.commit();
        session.close();
        return id;

    }

    /**
     * Delete a restaurant
     * @param restaurant
     */
    public void delete(Restaurant restaurant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(restaurant);
        transaction.commit();
        session.close();
    }




}
