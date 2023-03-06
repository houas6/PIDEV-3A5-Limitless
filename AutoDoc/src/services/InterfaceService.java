/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import models.*;
import java.util.List;

/**
 *
 * @author achra
 */
public interface InterfaceService {
    
    public void ajouterreclamation(reclamations r);
    public void ajouterpersonne2 (reclamations r);
    public void modifierpersonne(reclamations r);
    public void supprimerpersonne(int id);
    public List<reclamations> afficherreclamation();
    public void sendSms(String toPhoneNumber, String messageText);
    
    
    //public void sendsms();
}
