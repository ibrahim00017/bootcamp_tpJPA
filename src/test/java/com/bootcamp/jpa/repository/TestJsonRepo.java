/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Bailleur;
import com.bootcamp.entity.Beneficiaire;
import com.bootcamp.entity.Fournisseur;
import com.bootcamp.jpa.enums.TypeDeBailleur;
import com.bootcamp.jsonRepository.JsonRepo;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingIterator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Ibrahim
 */

public class TestJsonRepo {
    private Fournisseur fournisseur ;
       private   JsonRepo jsonRepo ;
    @Test
    public void  testObjectToJson(){
        fournisseur = new Fournisseur();
        fournisseur.setId(8L);
        fournisseur.setNom("Barrith Raimi");
      jsonRepo  = new JsonRepo();
        jsonRepo.objectToJson(fournisseur);
        System.out.println("test passed "+fournisseur.getNom());
       
     }
    
    @Test
    public void testJsonToObject(){
        
         jsonRepo  = new JsonRepo();
       List<Bailleur> bailleurs ;
       
       File file = new File("src/main/resources/files/bailleur.json");
       
        bailleurs = jsonRepo.jsonToObject(file);
     Iterator it =   bailleurs.iterator();
     if(it.hasNext()){
         System.out.println("test nomde  "+it.toString());
     }
          
          
        
    }
    
}
