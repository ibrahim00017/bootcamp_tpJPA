/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

/**
 *
 * @author Ibrahim
 */

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public abstract class BaseRepository<T> {

    private EntityManager em;
    private String unitPersistence="tpJpa";
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitPersistence);
    
    public BaseRepository(){
    em  = emf.createEntityManager();
        
    }

    public BaseRepository(String unitPersistence) {
        this.unitPersistence = unitPersistence;
         em  = emf.createEntityManager();

    }

    /**
     * Méthode de création
     *
     * @param obj
     * @return boolean
     * @throws SQLException
     * @throws EmptyFieldException
     */
    public boolean create(T obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        return true;
    }

    /**
     * Méthode pour effacer
     *
     * @param obj
     * @return boolean
     */
    public boolean delete(T obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        return true;
    }

    /**
     * Méthode de mise à jour
     *
     * @param obj
     * @return boolean
     */
    public boolean update(T obj) throws SQLException {
         em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
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