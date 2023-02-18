/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.services;

import edu.Gestion_Echange.entites.Echanges;
import edu.Gestion_Echange.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amine
 */
public class CRUDEchange implements InterfaceServices {
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public void ajouterechange(Echanges e) {
         try {
        ste = conn.createStatement();
        String req = "Insert into echanges values(0,'"+e.getProduit_echange()+"','"+e.getProduit_offert()+"','"+e.getStatut()+"','"+e.getCommentaire()+"')";
        ste.executeUpdate(req);
        System.out.println("echange ajouté");
    } catch (SQLException ex) {
            System.out.println("echange non ajouté!!!!");    }
    }

    @Override
    public void ajouterechange2(Echanges e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierechange(Echanges e) {
       try {
            String req = "UPDATE `echanges` SET `produit_echange` = '" + e.getProduit_echange() + "', `produit_offert` = '" + e.getProduit_offert() + "', `statut` = '" + e.getStatut()+ "', `commentaire` = '" + e.getCommentaire() +   "' WHERE `echanges`.`id_echange` = " + e.getId_echange();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerechange(int id) {
      try {
            String req = "DELETE FROM `echanges` WHERE id_echange = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("echange deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Echanges> afficherechange() {
        List<Echanges> ech = new ArrayList<Echanges>();
        try {
             ste =conn.createStatement();
        String req = "SELECT * FROM `echanges`";
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            Echanges resultPerson = new Echanges(result.getInt("id_echange"), result.getInt("produit_echange"), result.getInt("produit_offert"), result.getString("statut"), result.getString("commentaire"));
            ech.add(resultPerson);
        }
        System.out.println(ech);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return ech;
    }
    
}
