/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name = "tp_beneficiaire")
@DiscriminatorValue("BENEFICIAIRE")
public class Beneficiaire extends Personne {

    public Beneficiaire() {

    }

    public Beneficiaire(String nom) {
        super(nom);
    }
    @OneToMany
    private List<Programme> programmes = new ArrayList<Programme>();
    
     @OneToMany
     private List<Programme_has_Beneficiaire> programmeHasBeneficiaires =new ArrayList<Programme_has_Beneficiaire>();

    public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

//    @ManyToMany(cascade = {
//        CascadeType.PERSIST,
//        CascadeType.MERGE
//    })
//    @JoinTable(name = "beneficiaire_has_projet", joinColumns = @JoinColumn(name = "beneficiaire_id"),
//            inverseJoinColumns = @JoinColumn(name = "projet_id"))
//    private List<Projet> projets = new ArrayList<Projet>();
@OneToMany
    private List<Beneficiaire_has_Projet> beneficiaireHasProjet = new ArrayList<Beneficiaire_has_Projet>();

}
