/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Rapport;
import Utils.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CC
 */
public class RapportService {
    Connection  conn  = MaConnexion.getinstence().getcon();    
    
    public RapportService(){};
    public void ajouterRapport(Rapport ct){

        try {
            String requete = "INSERT INTO rapport (status,sujet,description,date_creation) VALUES (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(requete);
            st.setString(1,ct.getStatut());
            st.setString(2,ct.getSujet());
            st.setString(3,ct.getDescription());
            st.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
            st.executeUpdate();
            
        }catch (SQLException ex) {
            //Logger.getLogger(ContratService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur : "+ex.getMessage());
        }
    }
    
    public  List<Rapport> getSome(){
    List<Rapport> rapportList = new ArrayList();
        try {
            String query = "SELECT id_rapport ,status, sujet, description, date_creation FROM rapport";
            
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
            Rapport r = new Rapport();
            r.setId_rapport(rs.getInt(1));
            r.setStatut(rs.getString(2));
            r.setSujet(rs.getString(3));
            r.setDescription(rs.getString(4));
            r.setDate_creation(rs.getDate(5));
            
            rapportList.add(r);
            }    
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return rapportList;
    }
    public void supprimerRapport(Rapport ct) { 
        
        String requete = "DELETE FROM rapport where id_rapport = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, ct.getId_rapport());
            ps.executeUpdate();
            System.out.println("Rapport supprimé avec succées");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    
    }
    
    public void modifierRapport(int id_rapport, String status, String sujet, String description,int date_creation) { 
        
        try {
            String query = "UPDATE rapport SET status='"+status
                    +"' , sujet='"+sujet
                    +"' , description='"+description
                     +"' ,date_creation='"+date_creation
                    +" 'WHERE id_rapport="+id_rapport;
            
            Statement st =conn.createStatement();
            st.executeUpdate(query);
            System.out.println("Mise à jour effectuée avec succès");
        }catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    
    }

    public void modifierRapport(Rapport r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
