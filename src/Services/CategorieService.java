/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categorie;
import java.sql.PreparedStatement;
import Utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell
 */
public class CategorieService {
        Connection cnx = MaConnexion.getinstence().getcon();

      public boolean insert(Categorie c) {
        try
        {
            String query = "INSERT INTO categorie (nom) VALUES (?)";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setString(1, c.getNom());
            statement.executeUpdate();
            System.out.println("categorie ajouté");
            return true;
        }catch(SQLException ex)
        {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
      
        public List<Categorie> getAll() {
       List<Categorie> catList = new ArrayList();
        try{
         String query = "SELECT * FROM categorie";
         Statement statement = cnx.createStatement();
         ResultSet rs = statement.executeQuery(query);
         while(rs.next())
         {
             Categorie c = new Categorie(rs.getInt(1), rs.getInt(2), rs.getString(3));
             catList.add(c);
             
         }
        }catch(SQLException ex)
        {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catList;
    }
        
           public List<String> getAllString() {
       List<String> catList = new ArrayList();
        try{
         String query = "SELECT nom FROM categorie";
         Statement statement = cnx.createStatement();
         ResultSet rs = statement.executeQuery(query);
         while(rs.next())
         {
             Categorie c = new Categorie();
             c.setNom(rs.getString(1));
             catList.add(c.getNom());
             
         }
        }catch(SQLException ex)
        {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catList;
           }
           
              public List<String> getAllSousString(int cat_id) {
       List<String> catList = new ArrayList();
        try{
         String query = "SELECT nom FROM souscategorie WHERE cat_id = "+"'"+cat_id+"'";
         Statement statement = cnx.createStatement();
         ResultSet rs = statement.executeQuery(query);
         while(rs.next())
         {
             Categorie c = new Categorie();
             c.setNom(rs.getString(1));
             catList.add(c.getNom());
             
         }
        }catch(SQLException ex)
        {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catList;
           }
           
           
           public Categorie getBynom(String nom) {
        Categorie c = new Categorie();

        try{

         String query = "SELECT * FROM categorie WHERE nom = "+"'"+nom+"'";
         Statement statement = cnx.createStatement();
         ResultSet rs = statement.executeQuery(query);
         while(rs.next())
         {
             c.setId(rs.getInt(1));
             c.setNom(rs.getString(1));
             
         }
        }catch(SQLException ex)
        {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
           
           
       public boolean insertSousCat(Categorie c) {
        try
        {
            String query = "INSERT INTO souscategorie (cat_id,nom) VALUES (?,?)";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, c.getId());
            statement.setString(2, c.getNom());
            statement.executeUpdate();
            System.out.println("sous categorie ajouté");
            return true;
        }catch(SQLException ex)
        {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
