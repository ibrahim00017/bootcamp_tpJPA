/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name="tp_fournisseur")
@DiscriminatorValue("FOURNISSEUR")
public class Fournisseur extends Personne {
    public Fournisseur(){
        
    }
    
    public Fournisseur(String nom){
        super(nom);
    }
    
//    @ManyToMany(mappedBy="fournisseurs")
//    private List<Programme> programmes = new ArrayList<Programme>();
    @OneToMany
    private List<Programme_has_Fournisseur> programmeHasFournisseur = new ArrayList<Programme_has_Fournisseur>();
    @OneToMany
    private List<Projet_has_Fournisseur> projethasFournisseur  = new ArrayList<Projet_has_Fournisseur>();

    public List<Projet_has_Fournisseur> getProjethasFournisseur() {
        return projethasFournisseur;
    }

    public void setProjethasFournisseur(List<Projet_has_Fournisseur> projethasFournisseur) {
        this.projethasFournisseur = projethasFournisseur;
    }
    

    public List<Programme_has_Fournisseur> getProgrammeHasFournisseur() {
        return programmeHasFournisseur;
    }

    public void setProgrammeHasFournisseur(List<Programme_has_Fournisseur> programmeHasFournisseur) {
        this.programmeHasFournisseur = programmeHasFournisseur;
        
    }

 
    
    @OneToMany
    private List<Projet> projets = new ArrayList<Projet>();

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
    
}
