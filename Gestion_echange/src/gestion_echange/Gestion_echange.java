/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_echange;

import edu.Gestion_Echange.entites.Echanges;
import edu.Gestion_Echange.services.CRUDEchange;
import edu.Gestion_Echange.utils.MyConnection;
import edu.Gestion_Echange.entites.Livreur;
import edu.Gestion_Echange.services.CRUDLivreur;
import edu.Gestion_Echange.entites.Livraison;
import edu.Gestion_Echange.services.CRUDLivraison;

/**
 *
 * @author amine
 */
public class Gestion_echange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyConnection connexion = MyConnection.getInstance();
         //Personne p = new Personne("ben ali", "sarra");
      //  Personne p2 = new Personne("aziza", "sarra");
    //  Echanges e1=new Echanges(2,2,"","sel3a jdida");
      //Echanges e2=new Echanges(20,20,"","sel3a jdida");
     // Echanges e2=new Echanges(6,14,"annule","sel3a jdida");
     
      Livreur l1=new Livreur("le houas","lehouas@mail.com",59869411);
      CRUDLivreur crud1 = new CRUDLivreur();
        CRUDEchange crud = new CRUDEchange();
       CRUDLivraison crud2 = new CRUDLivraison();
       //crud2.afficherLivraison();
     // crud1.afficherLivreur();
      //  crud1.ajouterLivreur(l1);
        //crud.ajouterechange(e1);
       // crud.ajouterechange(e2);
     //   crud.afficherpersonnes();
      //  crud.supprimerechange(2);
     //  crud.afficherpersonnes();
        
    }
    
}
