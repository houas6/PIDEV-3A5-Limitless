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
         
         ServiceClient serv1 = new ServiceClient();
         //System.out.println(serv1.getclient(1));
         
         
         product p1 = new product(0,"ma9loub",3.5);
         product p2 = new product(0,"mlewi",7.5);
         ServiceProduct serv2= new ServiceProduct();
        // serv2.ajouterproduct(p1);
        // serv2.ajouterproduct(p2);
        // serv2.supprimerproduct(1);
        //serv2.afficherproduct();
       // System.out.println(serv2.getproduct(2));
         
       
       
       panier pan1= new panier(2);
       panier pan2= new panier(1);
       
       ServicePanier serv3 = new ServicePanier();
 
      //serv3.ajouterPanier(pan2, 2); 
    
       serv3.supprimerproduitpannier(1, 3);
      //serv3.supprimerPanier(1);
      // System.out.println(serv3.getpanier(1));
      // serv3.decrementQuantite(pan2, 2);
     // serv3.incrementQuantite(pan2, 2);
        
        
        commande c1= new commande(0,serv1.getclient(1),14.5);
        ServiceCommande serv4= new ServiceCommande();
        //serv4.ajoutercommande(c1);
       // System.out.println(serv4.recupererCommandeClient(1));
       //serv4.supprimercommande(3);
         
         
         
         
         
         
         
         
    }
    
}
