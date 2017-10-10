/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Bailleur;
import com.bootcamp.jsonRepository.JsonRepo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Ibrahim
 * 
 */
public class TestBailleurJsonRepo {

    private Bailleur bailleur;
    private JsonRepo jsonRepo;

    @Test
        public void testObjectToJson() {
            
        bailleur = new Bailleur();
        bailleur.setId(9L);
        bailleur.setNom("RAIMI Barriath");
        jsonRepo = new JsonRepo();
        jsonRepo.objectToJson(bailleur);
        System.out.println("test passed " + bailleur.getNom());

    }

    @Test
    public void testJsonToObject() {

        jsonRepo = new JsonRepo();
        List<Bailleur> bailleurs = getList();

//        File file = new File("src/main/resources/files/Bailleur.json");
//        bailleurs = jsonRepo.jsonToObject(file);
        Iterator it = bailleurs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        

    }
    
    private List<Bailleur> getList(){
        
        jsonRepo = new JsonRepo();
        List<Bailleur> bailleurs;

        File file = new File("src/main/resources/files/Bailleur.json");
        bailleurs = jsonRepo.jsonToObject(file);
        
        return bailleurs;
    }

}
