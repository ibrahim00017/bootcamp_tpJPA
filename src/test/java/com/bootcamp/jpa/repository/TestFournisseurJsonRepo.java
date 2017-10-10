/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Fournisseur;
import com.bootcamp.jsonRepository.JsonRepo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Ibrahim
 */
public class TestFournisseurJsonRepo {
    private Fournisseur fournisseur;
    private JsonRepo jsonRepo;

    @Test
        public void testObjectToJson() {
            
        fournisseur = new Fournisseur();
        fournisseur.setId(3L);
        fournisseur.setNom("founisseur3 ");
        jsonRepo = new JsonRepo();
        jsonRepo.objectToJson(fournisseur);
        System.out.println("test passed " + fournisseur.getNom());

    }

    @Test
    public void testJsonToObject() {

        jsonRepo = new JsonRepo();
        List<Fournisseur> fournisseurs = getList();

//        File file = new File("src/main/resources/files/Bailleur.json");
//        bailleurs = jsonRepo.jsonToObject(file);
        Iterator it = fournisseurs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        

    }
    
    private List<Fournisseur> getList(){
        
        jsonRepo = new JsonRepo();
        List<Fournisseur> fournisseurs;

        File file = new File("src/main/resources/files/Bailleur.json");
        fournisseurs = jsonRepo.jsonToObject(file);
        
        return fournisseurs;
    }
    
}
