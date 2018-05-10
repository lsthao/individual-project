package edu.matc.persistence;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;
/**
 * This class is a generic DAO to peform CRUD on entities.
 *
 * @Author Leja Thao
 */
public class GenericDAO<T> {
    private Class<T> type;
    Logger logger =  Logger.getLogger(this.getClass());

    public GenericDAO() {

    }

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * This method gets an entity by it's ID
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T>T getByID(int id) {
        Session session = getSession();
        T entity = (T)session.get( type, id );
        session.close();
        return entity;
    }

    /**
     * This method deletes an entity
     *
     * @param entity
     */
    public void delete( T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * This method gets all objects of this type
     * @return
     */
    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        List<T> entity = session.createQuery( query ).getResultList();

        logger.debug("The list of entity type " + entity);
        session.close();

        return entity;
    }

    /**
     * This method adds an entity.
     *
     * @param entity
     * @return
     */
    public int add(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * This method updates an entity.
     *
     * @param entity
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * This method performs a query to return a list of entities that have
     * a property name equal to the value argument.
     * @param propertyName
     * @param value
     * @return
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for " + type + " with " + propertyName + " = " + value);


        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery( query ).getResultList();

        session.close();
        return entities;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for type with {} = {}, " + propertyName + ", " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }

}