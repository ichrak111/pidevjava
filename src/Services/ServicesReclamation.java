/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import  Utils.MaConnexion;
import java.util.Date;
import Entities.Reclamation;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author FARHATI
 */
public class ServicesReclamation {
    Connection cnx=MaConnexion.getinstence().getcon();
    ObservableList<Reclamation> myList;
    
    public void addReclamation (Reclamation r){
        
        
        try{
            String query = "insert into reclamations(id_sender,id_reciever,titre,description,date_rec) values(?,?,?,?,?)";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, r.getId_Sender());
            statement.setInt(2, r.getId_reciever());
            statement.setString(3, r.getTitle());
            statement.setString(4, r.getDescription());
            statement.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
            statement.executeUpdate();

             
             
             //st.executeUpdate(";
             System.out.println("reclamation added");
         }
         catch(SQLException ex){
             System.out.println("Erreur add rec");
             
         }
        
        
    }
    
    
    public void deleteReclamation (int idRec){
        
        
        
        PreparedStatement pt;

        try {
            pt=cnx.prepareStatement("delete from reclamations where id_rec=?");
            pt.setInt(1,idRec);
            pt.executeUpdate();
            System.out.println("deleted");

        } catch (SQLException ex) {
            System.out.println("erreur delete");
            
            
        }
    }
    
    public ObservableList<Reclamation> listerReclamation (int id){
        myList=FXCollections.observableArrayList();

        try{
                    String sql="SELECT * FROM reclamations where id_user='"+id+"'";

            ResultSet rs=cnx.createStatement().executeQuery(sql);
            
            while(rs.next()){
                
                Reclamation rec1=new Reclamation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),rs.getDate(7));
                
               
                myList.add(rec1);
                
                
            }
            System.out.println("affichage");
        }
        catch(SQLException e)
        {
            System.out.println("no no no aff");
        }
     
       return myList;
        
    }
    
   /* public ObservableList<Reclamation> search (String titre){
        myList=FXCollections.observableArrayList();
        int id=1;

        try{
                    String sql="SELECT * FROM reclamations WHERE titre like '%"+titre+"%' AND Id_user='"+id+"'";

            ResultSet rs=cn.createStatement().executeQuery(sql);
            
            while(rs.next()){
                
                Reclamation rec1=new Reclamation(rs.getInt("id_rec"),id,rs.getString("titre"),rs.getString("description"),rs.getInt("etat"),rs.getDate("date_rec"));
                
               
                myList.add(rec1);
                
                
            }
            System.out.println("search");
        }
        catch(SQLException e)
        {
            System.out.println("no no no search");
        }
     
       return myList;
        
    }
    */

    /*
        public void updateReclamation(Reclamation rec){
             PreparedStatement pt;
        
        try{
             pt=cn.prepareStatement("update reclamations set Id_user=?,titre=?, description=?, etat=?,date_rec=? WHERE id_rec=?");
             pt.setInt(1,rec.getLogin_user());
             pt.setString(2, rec.getTitle());
             pt.setString(3, rec.getDescription());
             pt.setInt(4, rec.getEtat());
             pt.setDate(5, new java.sql.Date(rec.getDate_rec().getTime()));
             pt.setInt(6, rec.getId_rec());
             
             pt.executeUpdate();
             
             
             System.out.println("reclamation Updated");
         }
         catch(SQLException ex){
             System.out.println("Erreur update");
             
         }
        }
    */
}
