/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhia.tests;

import Entities.Utilisateur;
import conexionbd.services.CRUDUtilisateur;
import joksova.utils.MyConnection;

/**
 *
 * @author hasse
 */
public class Joksova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CRUDUtilisateur cu= new CRUDUtilisateur();
        Utilisateur u1 = new Utilisateur("Hamdi","Dhaouedi","ham123@gmail.com");
        //cu.ajouterUtilisateur2(u1);
        //System.out.println(cu.afficherUtilsateur());
        System.out.println(cu.afficherUtilisateur());
    }
    
}
