/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Bailleur;

import com.bootcamp.jpa.enums.TypeDeBailleur;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.persistence.Persistence;
import org.testng.annotations.Test;

/**
 *
 * @author Ibrahim
 */
public class BailleurRepositoryTest  {
    @Test  
   
    public void testCreate() throws SQLException {
        System.out.println("Bailleur repository testing .... create");
        TypeDeBailleur type = TypeDeBailleur.gouvernementale;
        System.out.println("type de have been created");
        Bailleur bailleur = new Bailleur();
        bailleur.setId(1L);
        bailleur.setNom("Ganiou");
        bailleur.setTypeDeBailleur(type);
        System.out.println("a new bailleur have been created");
        BailleurRepository instance = new BailleurRepository();
        System.out.println("a bailleur repository de have been created");
        instance.create(bailleur);
        // TODO review the generated test code and remove the default call to fail.
        System.out .println("un bailleur enregistre "+bailleur.getNom());
    }

    

    /**
     * Test of delete method, of class BailleurRepository.
     */
//    public void testDelete() {
//        System.out.println("delete");
//        Bailleur bailleur = null;
//        BailleurRepository instance = new BailleurRepository();
//        instance.delete(bailleur);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of find method, of class BailleurRepository.
//     */
//    public void testFind() {
//        System.out.println("find");
//        Long bailleur_id = null;
//        BailleurRepository instance = new BailleurRepository();
//        Bailleur expResult = null;
//        Bailleur result = instance.find(bailleur_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class BailleurRepository.
//     */
//    public void testUpdate() {
//        System.out.println("update");
//        Bailleur bailleur = null;
//        BailleurRepository instance = new BailleurRepository();
//        instance.update(bailleur);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
