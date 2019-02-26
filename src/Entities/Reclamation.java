/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;



/**
 *
 * @author FARHATI
 */
public class Reclamation {
    int id_rec;
    int id_sender;
    int id_reciever;
    String title;
    String description;
    boolean etat;
    Date date_rec;
    
    public Reclamation(int id_rec,int id_sender, int id_reciever, String title, String description, boolean etat,Date date)
    {
        this.id_rec = id_rec;
        this.id_sender = id_sender;
        this.id_reciever = id_reciever;
        this.title = title;
        this.description = description;
        this.etat = etat;
        this.date_rec = date;
    }
    
    public Reclamation(int id_sender, int id_reciever, String title, String description)
    {
        this.id_sender = id_sender;
        this.id_reciever = id_reciever;
        this.title = title;
        this.description = description;
    }
    public int getId_sender() {
        return id_sender;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    public int getId_reciever() {
        return id_reciever;
    }

    public void setId_reciever(int id_reciever) {
        this.id_reciever = id_reciever;
    }
    
    public Reclamation (){}
     {
        this.id_rec=id_rec;
        this.id_sender = id_sender;
        this.title = title;
        this.description = description;
        this.etat = etat;
        this.date_rec = date_rec;
    }
   

    /*public Reclamation(int id_sender, String title, String description, int etat, Date date_rec) {
        this.id_sender = id_sender;
        this.title = title;
        this.description = description;
        this.etat = etat;
        this.date_rec = date_rec;
    }*/
    
   /* public Reclamation(String title, String description, int etat, Date date_rec) {
        
        this.title = title;
        this.description = description;
        this.etat = etat;
        this.date_rec = date_rec;
    }*/

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public int getId_Sender() {
        return id_sender;
    }

    public void setLogin_user(int id_sender) {
        this.id_sender = id_sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }
    
    
    
}
