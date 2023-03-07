/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.*;
import BD.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amine
 */
public class CRUDEchange implements InterfaceServicesEchanges {
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
@Override
   public int getIdechange (int n ){
    int t=0 ;
    try {   
            String requete = "select * from echanges where ?= id_echange";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, n);
            ResultSet e = pst.executeQuery();
            while(e.next()){
            Echanges pre = new Echanges();
           
            pre.setId_echange(e.getInt("id_echange"));
            t=pre.getId_echange();   }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
return t ;
   } 
   
   
   @Override
    public List<Echanges> afficherechangeFront(int id) {
        List<Echanges> ech = new ArrayList<Echanges>();
        try {
            
           ste =conn.createStatement();
        String req = "SELECT * FROM `echanges`  ";
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
   
   
@Override
public List<Echanges> searchEchange(String searchTerm) {
    List<Echanges> echangeList = new ArrayList<>();
    try {
        String requete = "SELECT * FROM echanges WHERE id_echange = ?";
        PreparedStatement pst = conn.prepareStatement(requete);
        pst.setInt(1, Integer.parseInt(searchTerm));
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Echanges echange = new Echanges();
            echange.setId_echange(rs.getInt("id_echange"));
            echange.setProduit_echange(rs.getInt("produit_echange"));
            echange.setProduit_offert(rs.getInt("produit_offert"));
            echange.setStatut(rs.getString("statut"));
            echange.setCommentaire(rs.getString("commentaire"));
            echangeList.add(echange);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return echangeList;
}

}
