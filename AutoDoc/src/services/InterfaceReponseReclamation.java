/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.*;

/**
 *
 * @author achra
 */
public interface InterfaceReponseReclamation {
    public void ajouterReponse(reponse_reclamation r);
    public List<reponse_reclamation> afficherReponseReclamation();
    public void supprimerReponseReclamation(int id);
}
