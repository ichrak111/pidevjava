/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sarra
 */
public class MaConnexion {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/projet3";
    private static final String user = "root";
    private static final String password ="";
    
    private static  Connection conn;
    
    public Connection getcon(){
        return conn;
    }
    
    public MaConnexion(){
         try {
            conn = DriverManager.getConnection(url,user,password);
             System.err.println("connecté");
        } catch (SQLException ex) {
            //Logger.getLogger(MO_Bleed_jf.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("MO_ERROR_CONN !!");
            System.out.println(ex.getMessage());
        }   
    }
    private static  MaConnexion  inst ;
    public static MaConnexion getinstence(){
        
        if(inst == null){
            inst = new MaConnexion();
        }
        return inst;
    }  
}
