/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greclamation;

import BD.MyConnection;
import model.reclamations;
import services.CrudReclamation;

/**
 *
 * @author achra
 */
public class Greclamation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         MyConnection connexion = MyConnection.getInstance();
         reclamations r = new reclamations("mus", "carte mere","defaillante");
         CrudReclamation crud = new CrudReclamation();
         crud.ajouterreclamation(r);
         //crud.modifierreclamation(r);
         //crud.supprimerreclamation(0);
         System.out.println(crud.afficherreclamation());
        // TODO code application logic here
    }
    
}
