/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.Date;

/**
 *
 * @author CC
 */
public class Rapport {
    public int id_rapport;
    public int id_rapport_reponse;
    public int id_rapport_categorie;
    public int id_rapport_subcategorie;
    public String statut;
    public String sujet;
    public String description;
    public Date date_creation;

    public Rapport(String statut, String sujet, String description) {
        this.statut = statut;
        this.sujet = sujet;
        this.description = description;
    }
    
    public Rapport(){}

   

    public void setId_rapport(int id_rapport) {
        this.id_rapport = id_rapport;
    }

    public void setId_rapport_reponse(int id_rapport_reponse) {
        this.id_rapport_reponse = id_rapport_reponse;
    }

    public void setId_rapport_categorie(int id_rapport_categorie) {
        this.id_rapport_categorie = id_rapport_categorie;
    }

    public void setId_rapport_subcategorie(int id_rapport_subcategorie) {
        this.id_rapport_subcategorie = id_rapport_subcategorie;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public int getId_rapport() {
        return id_rapport;
    }

    public int getId_rapport_reponse() {
        return id_rapport_reponse;
    }

    public int getId_rapport_categorie() {
        return id_rapport_categorie;
    }

    public int getId_rapport_subcategorie() {
        return id_rapport_subcategorie;
    }

    public String getStatut() {
        return statut;
    }

    public String getSujet() {
        return sujet;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate_creation() {
        return date_creation;
    }
}
