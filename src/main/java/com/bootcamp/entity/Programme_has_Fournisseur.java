/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entity;

import javax.persistence.ManyToOne;

/**
 *
 * @author Ibrahim
 */
public class Programme_has_Fournisseur {
    @ManyToOne
    private Programme programme;
    @ManyToOne
    private Fournisseur fournisseur;
    
}
