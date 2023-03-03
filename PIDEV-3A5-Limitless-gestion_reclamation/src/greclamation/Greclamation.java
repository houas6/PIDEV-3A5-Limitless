/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greclamation;

import BD.MyConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.reclamations;
import model.reponse_reclamation;
import services.CrudReclamation;
import services.CrudReponseReclamation;
import services.MetierReclamation;

/**
 *
 * @author achra
 */
public class Greclamation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
         MyConnection connexion = MyConnection.getInstance();
         //reponse_reclamation r = new reponse_reclamation(0,"prob resolu", 6);
//         CrudReponseReclamation crud = new CrudReponseReclamation();
         MetierReclamation met = new MetierReclamation();
         //System.out.println(met.getUserById(13).getMail());
         //System.out.println(met.findById(6));
         
//        try {
//            met.sendMail(r);
//            } catch (Exception ex) {
//            Logger.getLogger(Greclamation.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         reclamations r = new reclamations(6, "carte mere","defaillante");
//        CrudReclamation crud = new CrudReclamation();
        met.sendSms("+21695337153", "test test");
//        crud.ajouterreclamation(r);
//        System.out.println(crud.afficherreclamation());
//met.SearchByName("noss");
//crud.modifierreclamation(r);
//crud.supprimerreclamation(0);
//         System.out.println(crud.afficherreclamation());
// TODO code application logic here
        
    }
    
}
