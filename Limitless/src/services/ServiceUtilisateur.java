/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import DB.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.*;
import models.utilisateur;

/**
 *
 * @author rassa
 */
public class ServiceUtilisateur implements InterfaceServicesUtilisateur{
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
 
    @Override
    public utilisateur getutilisateur(int id_user) {
         try {
        String req = "SELECT * FROM `utilisateur` WHERE id_user = ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_user);
        
        ResultSet result = pste.executeQuery();
       result.next();
           utilisateur resultutilisateur = new utilisateur(result.getInt("id_user"), result.getString("password"), result.getString("mail"), result.getString("nom") , result.getString("prenom") , result.getString("adresse") , result.getString("role") , result.getString("cin") , result.getString("username"));
        return resultutilisateur;
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
    return null;
    }
    
        }