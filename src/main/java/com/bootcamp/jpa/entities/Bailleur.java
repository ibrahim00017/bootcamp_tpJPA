/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import com.bootcamp.jpa.enums.TypeDeBailleur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name="tp_bailleur")
@DiscriminatorValue("BAILLEUR")
public class Bailleur extends Personne {
   
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length=45)
    @NotNull(message="veillez choisir le type de Bailleur ...!")
    private TypeDeBailleur typeDeBailleur;

    public TypeDeBailleur getTypeDeBailleur() {
        return typeDeBailleur;
    }

    public void setTypeDeBailleur(TypeDeBailleur typeDeBailleur) {
        this.typeDeBailleur = typeDeBailleur;
    }
    
   
    
//
  @OneToMany
  private List<Bailleur_has_Programme> bailleur_has_programme = new ArrayList<Bailleur_has_Programme>();
  @OneToMany
 private List<Bailleur_has_Projet> bailleurHasProjet = new ArrayList<Bailleur_has_Projet>();
  
//default constructor
    public Bailleur() {
    }

    public List<Bailleur_has_Projet> getBailleurHasProjet() {
        return bailleurHasProjet;
    }

    public void setBailleurHasProjet(List<Bailleur_has_Projet> bailleurHasProjet) {
        this.bailleurHasProjet = bailleurHasProjet;
    }


    public Bailleur(String nom) {
        super(nom);
    }
    
    public Bailleur(String nom,TypeDeBailleur type){
        super(nom);
        typeDeBailleur = type;
        
    }

    public List<Bailleur_has_Programme> getBailleur_has_programme() {
        return bailleur_has_programme;
    }

    public void setBailleur_has_programme(List<Bailleur_has_Programme> bailleur_has_programme) {
        this.bailleur_has_programme = bailleur_has_programme;
    }






}
