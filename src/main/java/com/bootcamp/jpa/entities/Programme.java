/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name="tp_programme")
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return this.id;
    }
    @OneToMany
     private List<Programme_has_Beneficiaire> programmeHasBeneficiaires =new ArrayList<Programme_has_Beneficiaire>();
    
        
    @Column(length=45)
    @NotNull(message="veillez entrer un nom svp")
    private String nom;
    
    @Column(length=45)
    @NotNull(message="L'Objectif du programme...!")
    private String objectif;
    
    public Programme(){
        
    }
    
    public Programme(String nom){
        this.nom =nom;
    }
    
     public Programme(String nom,String objectif){
        this.nom =nom;
        this.objectif=objectif;
    }
    
    @OneToOne
    @NotNull(message="donnez un indicateur de la performance du programme...!")
    private IndicateurPerformance indicateurPerformance;


    //OneToMany bailleur has pragramme
    @OneToMany
    private List<Bailleur_has_Programme> bailleur_has_programme= new ArrayList<Bailleur_has_Programme>();
    // ManyToMany for the relation programme_has_fournisseur
//    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
//    @JoinTable(name="programme_has_fournisseur",
//            joinColumns=@JoinColumn(name="programme_id"),
//            inverseJoinColumns=@JoinColumn(name="fournisseur_id"))
    @OneToMany
    private List<Programme_has_Fournisseur> programmeHasFournisseur = new ArrayList<Programme_has_Fournisseur>();

    public List<Bailleur_has_Programme> getBailleur_has_programme() {
        return bailleur_has_programme;
    }

    public void setBailleur_has_programme(List<Bailleur_has_Programme> bailleur_has_programme) {
        this.bailleur_has_programme = bailleur_has_programme;
    }
        
    
    public IndicateurPerformance getIndicateurPerformance() {
        return this.indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjectif() {
        return this.objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.Programme[ id=" + id + " ]";
    }
    
}
