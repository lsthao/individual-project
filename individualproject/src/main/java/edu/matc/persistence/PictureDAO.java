package edu.matc.persistence;

import edu.matc.entity.Picture;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class PictureDAO {

    private final Logger log = Logger.getLogger(this.getClass());

    public List<Picture> getAllPictures() {
        List<Picture> pictures = new ArrayList<Picture>();
        Session session = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            pictures = session.createCriteria(Picture.class).list();

        } catch(HibernateException hibernateException) {
            log.error(hibernateException.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pictures;
    }

    public Picture getPicture(int id) {
        Picture picture = null;
        Session session = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            picture = (Picture) session.get(Picture.class, id);

        } catch (HibernateException hibernateException) {
            log.error(hibernateException.getMessage());
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return picture;
    }

    public int addPicture(Picture picture) {
        Transaction transaction = null;
        Session session = null;
        int id = 0;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = (Integer)session.save(picture);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            log.error(hibernateException.getMessage());
        }
        return id;
    }

    public void deletePicture(int id) {
        Session session = null;
        Transaction transaction = null;

        Picture picture = getPicture(id);

        try {
            transaction = session.beginTransaction();
            session.delete(picture);
        } catch (RuntimeException runtimeException) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (transaction != null) {
                transaction.commit();
            }
            session.flush();
            session.close();
        }

    }

    



}
