/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Bailleur;
import com.bootcamp.entity.Beneficiaire;
import com.bootcamp.jsonRepository.JsonRepo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Ibrahim
 */
public class TestBeneficiaireJsonRepo {
    
    private Beneficiaire beneficiaire;
    private JsonRepo jsonRepo;

    @Test
        public void testObjectToJson() {
            
        beneficiaire = new Beneficiaire();
        beneficiaire.setId(1L);
        beneficiaire.setNom("benficiaire 1 ");
        jsonRepo = new JsonRepo();
        jsonRepo.objectToJson(beneficiaire);
        System.out.println("test passed " + beneficiaire.getNom());

    }

    @Test
    public void testJsonToObject() {

        jsonRepo = new JsonRepo();
        List<Beneficiaire> beneficiaires = getList();

//        File file = new File("src/main/resources/files/Bailleur.json");
//        bailleurs = jsonRepo.jsonToObject(file);
        Iterator it = beneficiaires.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        

    }
    
    private List<Beneficiaire> getList(){
        
        jsonRepo = new JsonRepo();
        List<Beneficiaire> beneficiaires;

        File file = new File("src/main/resources/files/Bailleur.json");
        beneficiaires = jsonRepo.jsonToObject(file);
        
        return beneficiaires;
    }
}
