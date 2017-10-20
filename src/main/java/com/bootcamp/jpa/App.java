package com.bootcamp.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeDeBailleur;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpJpa");
	     EntityManager em = emf.createEntityManager();
	     Bailleur bailleur = new Bailleur();
	     bailleur.setId(2L);
	     System.out.println("a new bailleur has been created");
	      bailleur.setNom("Ibrahim");
	     System.out.println("the name of baiileur hs been set");
	      bailleur.setTypeDeBailleur(TypeDeBailleur.gouvernementale);
	      System.out.println("the type of bailleur has benn set");
	     em.getTransaction().begin();
	     em.persist(bailleur);
	     em.getTransaction().commit();
	     System.out.println("the bailleur has been ad in to database");

	}

}
