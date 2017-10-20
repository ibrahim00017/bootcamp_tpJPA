package com.bootcamp.jpa.repository;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Ibrahim
 */
public abstract class BaseRepository<T> {

    private EntityManager em;
    private String unitPersistence;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitPersistence);

    public BaseRepository(String unitPersistence) {
        this.unitPersistence = unitPersistence;

    }
    
    public BaseRepository(){
        
    }

    /**
     * Methode de création
     *
     * @param obj
     * @return boolean
     * @throws SQLException
     * @throws EmptyFieldException
     */
    public boolean create(T obj) throws SQLException {
        em.persist(obj);
        return true;
    }

    /**
     * Méthode pour effacer
     *
     * @param obj
     * @return boolean
     */
    public boolean delete(T obj) throws SQLException {
        em.remove(obj);
        return true;
    }

    /**
     * Méthode de mise à jour
     *
     * @param obj
     * @return boolean
     */
    public boolean update(T obj) throws SQLException {
        em.merge(obj);
        return true;
    }

    /**
     * Méthode de recherche des informations
     *
     * @param id
     * @return T
     */
    public T findByProperty(String propertyName, Object value) throws SQLException {
        T result = null;

        String className = result.getClass().getSimpleName();
        String query = "select t from " + className + " t where t." + propertyName + "=:param";
        Query qry = getEm().createQuery(query);
        qry.setParameter("param", value);
        return (T) qry.getSingleResult();

    }

    /*
	  * Méthode de recherche de tous les objets
     */
    public abstract List<T> findAll() throws SQLException;

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(getUnitPersistence());
        setEm(emf.createEntityManager());
        return getEm();
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the unitPersistence
     */
    public String getUnitPersistence() {
        return unitPersistence;
    }

    /**
     * @param UnitPersistence the unitPersistence to set
     */
    public void setUnitPersistence(String unitPersistence) {
        this.unitPersistence = unitPersistence;
    }
}
