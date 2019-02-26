/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Dell
 */
public class Categorie {
    int id;
    int sous_id;
    String nom; 
    
    public Categorie()
    {
        
    }
    
    public Categorie(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }
    
     public Categorie(int id,int sous_id, String nom)
    {
        this.id = id;
        this.nom = nom;
        this.sous_id = sous_id;
    }
      
    public Categorie(String nom)
    {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public int getSous_id() {
        return sous_id;
    }

    public void setSous_id(int sous_id) {
        this.sous_id = sous_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}


