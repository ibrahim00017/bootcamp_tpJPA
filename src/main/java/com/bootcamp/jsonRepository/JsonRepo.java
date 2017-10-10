/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jsonRepository;

import com.bootcamp.entity.Bailleur;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static javafx.scene.input.KeyCode.T;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import jdk.nashorn.internal.parser.JSONParser;

/**
 *
 * @author Ibrahim
 */
public class JsonRepo<T> {
    
    public JsonRepo(){
        
    }
   // private  Bailleur bailleur = new Bailleur();
    //String file = "src/main/resources/files/bailleur.json";
    //FileWriter fw =  new FileWriter(file,true);
    
 
    public void objectToJson(T object){
       File file = new File( "src/main/resources/files/"+object.getClass().getSimpleName()+".json");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(JsonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            List<T> list = new ArrayList<T>();
            list.add(object);
            writer.writeValue(file, list);
        } catch (IOException ex) {
            Logger.getLogger(JsonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
      
//        
//        try {
//            if(file.isEmpty()){
//                FileWriter fw =  new FileWriter(file,true);
//                fw.write("[");
//                String inst = mapper.writeValueAsString(bailleur);
//                fw.write(inst);
//                fw.write("]");
//            
//            }
//             FileWriter fw =  new FileWriter(file,true);
//            //mapper.writeValue(file, bailleur);
//            String inst = mapper.writeValueAsString(bailleur);
//            fw.write(inst);
//            
//            fw.close();
//        } catch (IOException ex) {
//            Logger.getLogger(BailleurJsonRepo.class.getName()).log(Level.SEVERE, null, ex);
//        }
      
//        
//        try {
//            if(file.isEmpty()){
//                FileWriter fw =  new FileWriter(file,true);
//                fw.write("[");
//                String inst = mapper.writeValueAsString(bailleur);
//                fw.write(inst);
//                fw.write("]");
//            
//            }
//             FileWriter fw =  new FileWriter(file,true);
//            //mapper.writeValue(file, bailleur);
//            String inst = mapper.writeValueAsString(bailleur);
//            fw.write(inst);
//            
//            fw.close();
//        } catch (IOException ex) {
//            Logger.getLogger(JsonRepo.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
  
    public List<T> jsonToObject(File file){
       List<T> result = null;
       
      //  File fileName = new File( "src/main/resources/files/"+object.getClass().getSimpleName()+".json");
       ObjectMapper mapper = new ObjectMapper();
       
        try {
            JsonFactory jsonFactory = new JsonFactory();
           JsonParser jsonParser = jsonFactory.createParser(file);
           TypeReference<List<T>> mapType = new TypeReference<List<T>>(){};
            result =  mapper.readValue(jsonParser,mapType);
        } catch (IOException ex) {
            Logger.getLogger(JsonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        JsonFactory jsonFactory = new JsonFactory();
//        try {
//            JsonParser jsonParser = jsonFactory.createParser(fileName);
//        } catch (IOException ex) {
//            Logger.getLogger(JsonRepo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return result;
    }
    
}
