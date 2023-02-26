/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limitless;
import DB.MyConnection;
import java.sql.Date;
import services.*;
import models.*;
/**
 *
 * @author rassa
 */
public class Limitless {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         MyConnection connexion = MyConnection.getInstance();
         
        ServiceUtilisateur serv1 = new ServiceUtilisateur();
        // System.out.println(serv1.getutilisateur(1));
         
         
         produit p1 = new produit(0,"ma9loub",3.5,"ma9loub jben",1);
         produit p2 = new produit(0,"mlewi",7.5,"mlewi 7ar",1);
         ServiceProduct serv2= new ServiceProduct();
      //  serv2.ajouterproduct(p1);
        // serv2.ajouterproduct(p2);
        //serv2.supprimerproduct(15);
        //serv2.afficherproduct();
     //  System.out.println(serv2.getproduct(16));
         
       
       
      panier pan1= new panier(2);
       panier pan2= new panier(1);
       
       ServicePanier serv3 = new ServicePanier();
 
   serv3.ajouterPanier(pan2, 16); 
    
      //serv3.supprimerproduitpannier(1, 16);
    // serv3.supprimerPanier(1);
     // System.out.println(serv3.getpanier(1));
    // serv3.decrementQuantite(pan2, 16);
     //serv3.incrementQuantite(pan2, 16);
       // System.out.println(serv3.getQuantite(1, 16));
       // System.out.println(serv3.getpanier(1).getTotal_panier());
        
        
        commande c1= new commande(0,serv1.getutilisateur(1),14.5);
        ServiceCommande serv4= new ServiceCommande();
        //serv4.ajoutercommande(c1);
       // System.out.println(serv4.recupererCommandeClient(1));
       //serv4.supprimercommande(1);
         
       // System.out.println(serv4.afficherCommands());
       commande c= new commande(4,"paye");
      // serv4.modifierCommand(c);
         
         
         
         
        
         
         
    }
    
}
