/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.jpa.entities.Bailleur;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ibrahim
 */
public class BailleurRepository {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("tpJpa");
    EntityManager em = emf.createEntityManager();
    //Bailleur bailleur =new Bailleur();
  
    public void create(Bailleur bailleur){
     //   Bailleur bailleur = new Bailleur(nom);
        em.getTransaction().begin();
        em.persist(bailleur);
        em.getTransaction().commit();
        System.out.println("le bailleur "+ bailleur.getNom()+" a ete bien a la base");
    }
    
}
