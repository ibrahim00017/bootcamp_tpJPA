/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ibrahim
 */
@Entity
public class Programme_has_Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @ManyToOne
    private Programme programme;
    @ManyToOne
    private Fournisseur fournisseur;
    
}
