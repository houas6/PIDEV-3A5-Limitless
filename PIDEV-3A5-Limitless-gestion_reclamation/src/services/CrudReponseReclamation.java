/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import BD.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.reclamations;
import model.reponse_reclamation;

/**
 *
 * @author achra
 */
public class CrudReponseReclamation implements InterfaceReponseReclamation{
    Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
        @Override
    public void ajouterReponse(reponse_reclamation r) {
    try {
        System.out.println("/////////");
        System.out.println(conn);
        System.out.println("/////////");
        ste = conn.createStatement();
        String req = "INSERT INTO `reponse_reclamation` VALUES(0,'"+r.getContenu()+"',"+r.getId_reclamation()+")";
        System.out.println(req);
        ste.executeUpdate(req);
        System.out.println("reponse ajouté");
    } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Reponse non ajouté!!!!");    }
    }
    @Override
    public List<reponse_reclamation> afficherReponseReclamation() {
        List<reponse_reclamation> rep = new ArrayList<>();
        try {
        String req = "SELECT * FROM `reponse_reclamation`";
        ste = conn.createStatement();
        ResultSet result = ste.executeQuery(req);
        System.out.println(result);
        while (result.next()) {
            reponse_reclamation resultRep = new reponse_reclamation(result.getInt("id"), result.getString("contenu"), result.getInt("id_reclamation"));
            rep.add(resultRep);
        }
        System.out.println(rep);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return rep;
 }
    public void supprimerReponseReclamation(int id) {
        try {
            String req = "DELETE FROM `reponse_reclamation` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("repponse deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
