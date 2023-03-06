/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import BD.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.*;

/**
 *
 * @author rassa
 */
public class ServiceUtilisateur implements InterfaceServicesUtilisateur{
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
 
    @Override
    public Utilisateur getutilisateur(int id_user) {
         try {
        String req = "SELECT * FROM `utilisateur` WHERE id_user = ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_user);
        
        ResultSet result = pste.executeQuery();
       result.next();
           Utilisateur resultutilisateur = new Utilisateur(result.getInt("id_user"), result.getString("numero"), result.getString("nom"), result.getString("prenom") , result.getString("cin") , result.getString("role") , result.getString("password") , result.getString("mail") , result.getString("adresse"));
        return resultutilisateur;
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
    return null;
    }
    
        }