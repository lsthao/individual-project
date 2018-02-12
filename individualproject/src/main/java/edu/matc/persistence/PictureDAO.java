package edu.matc.persistence;

import edu.matc.entity.Picture;
import org.apache.log4j.Logger;
import org.hibernate.*;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PictureDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get all pictures
     */
    public List<Picture> getAllPictures() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Picture> query = builder.createQuery(Picture.class);

        Root<Picture> root = query.from(Picture.class);
        List<Picture> pictures = session.createQuery(query).getResultList();

        session.close();

        return pictures;

    }

    /**
     * Get picture by ID
     * @param id id of picture
     */
    public Picture getPictureByID(int id) {
        Session session = sessionFactory.openSession();
        Picture picture = session.get(Picture.class, id);
        session.close();
        return picture;
    }

    /**
     * Update picture
     * @param picture picture to be updated
     */
    public void updatePicture(Picture picture) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(picture);
        session.close();
    }

    /**
     * Add a picture
     * @param picture picture to be added
     */

    public int addPicture(Picture picture) {
        int id = 0;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(picture);
        transaction.commit();
        session.close();
        return id;

    }

    /**
     * Delete a picture
     * @param picture
     */
    public void delete(Picture picture) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(picture);
        transaction.commit();
        session.close();
    }


    /**
     * Get picture by property
     */

    public List<Picture> getPictureByProperty(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Picture> query = builder.createQuery(Picture.class);
        Root<Picture> root = query.from(Picture.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Picture> pictures = session.createQuery( query ).getResultList();
        session.close();
        return pictures;

    }

}
