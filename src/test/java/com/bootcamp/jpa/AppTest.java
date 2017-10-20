package com.bootcamp.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.Test;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeDeBailleur;

/**
 * Unit test for simple App.
 */
public class AppTest  
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	@Test
	public void createBailleur() {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpJpa");
     EntityManager em = emf.createEntityManager();
     Bailleur bailleur = new Bailleur();
     bailleur.setId(1L);
     System.out.println("a new bailleur has been created");
      bailleur.setNom("toto");
     System.out.println("the name of baiileur hs been set");
      bailleur.setTypeDeBailleur(TypeDeBailleur.prive);
      System.out.println("the type of bailleur has benn set");
     em.getTransaction().begin();
     em.persist(bailleur);
     em.getTransaction().commit();
     System.out.println("the bailleur has been ad in to database");
	}
}
