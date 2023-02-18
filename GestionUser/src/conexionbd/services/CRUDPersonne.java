/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd.services;

import Entities.Personne;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import joksova.utils.MyConnection;

/**
 *
 * @author hasse
 */
public class CRUDPersonne implements EService {

    @Override
    public void ajouterpersonne(Personne p) {
        try {
        Statement ste = new MyConnection().getCnx().createStatement();
        String req = "Insert into personne values(0,'"+p.getNom()+"','"+p.getPrenom()+"')";
        ste.executeUpdate(req);
        System.out.println("Personne ajoute");
        }
       catch(SQLException ex)
        {
            System.out.println("personne non ajoute!!!!");
        }
    }

    @Override
    public void ajouterpersonne2(Personne p) {
    }

    @Override
    public void modifierpersonne(Personne p) {
    }

    @Override
    public void supprimerrpersonne(int id) {
    }

    @Override
    public List<Personne> afficherpersonne() {
        return null;
    }
    
    
}
