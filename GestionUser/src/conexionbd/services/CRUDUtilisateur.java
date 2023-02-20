/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd.services;

import conexionbd.services.implementations.IUtilisateur;
import Entities.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import joksova.utils.MyConnection;

/**
 *
 * @author hasse
 */
public class CRUDUtilisateur implements IUtilisateur {

    public CRUDUtilisateur() {
    }

    @Override
    public void ajouterUtilisateur() {

        try {
            String requete = "INSERT INTO utilisateur(username,password,mail) VALUES ('dhia','saibi','dhiaeddine.saibi@esprit.tn')";
            Statement st = new MyConnection().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Utilisateur ajoute");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void ajouterUtilisateur2(Utilisateur u) {

        try {
            String requete2 = "INSERT INTO utilisateur(password,mail,nom,prenom,role,cin,numero) VALUES (?,?,?,?,'client',?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            
            pst.setString(1, u.getPassword());
            pst.setString(2, u.getMail());
            pst.setString(3, u.getNom());
            pst.setString(4, u.getPrenom());
            pst.setString(5, u.getCin());
            pst.setString(6, u.getNumero());
            pst.executeUpdate();
            System.out.println("Utilisateur ajoute (methode dynamique)");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    @Override
    public void supprimerUtilisateur(int id) {
        try {
            String requete4 = "DELETE FROM utilisateur where id_user="+id;
            Statement st3=new MyConnection().getCnx().createStatement();
            st3.executeUpdate(requete4);
            System.out.println("Utilisateur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifierUtilisateur (int id, String nom, String mdp, String mail)
    {
        try {
            String Requete5="UPDATE utilisateur SET username='"+nom+"',password='"+mdp+"', mail='"+mail+"' where id_user="+id;
            PreparedStatement st4=new MyConnection().getCnx().prepareStatement(Requete5);
            st4.executeUpdate();
            System.out.println("Utilisateur modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }

    @Override
    public List<Utilisateur> afficherUtilisateur() {
        List<Utilisateur> users = new ArrayList<>();
        try {
            
            String requete3="SELECT * FROM utilisateur";
            Statement st=new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while(rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setId_user(rs.getInt(1));
            u.setUsername(rs.getString(2));
            u.setPassword(rs.getNString(3));
            u.setMail(rs.getString(4));
            users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
return users;
    }
    
   

}