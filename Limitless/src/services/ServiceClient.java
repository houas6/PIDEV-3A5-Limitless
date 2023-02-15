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
import models.client;

/**
 *
 * @author rassa
 */
public class ServiceClient implements InterfaceServicesClient{
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
 
    @Override
    public client getclient(int id_client) {
         try {
        String req = "SELECT * FROM `client` WHERE id_client = ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_client);
        
        ResultSet result = pste.executeQuery();
       result.next();
           client resultClient = new client(result.getInt("id_client"), result.getString("nom_client"), result.getString("prenom_client"), result.getString("adresse_client"));
        return resultClient;
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
    return null;
    }
    
        }