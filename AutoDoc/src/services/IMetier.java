/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;
import models.*;
import models.Utilisateur;

/**
 *
 * @author achra
 */
public interface IMetier{
    public List<reclamations> SearchByEtat(String name);
    public void sendMail(reponse_reclamation client ,String mail) throws Exception;
    public reclamations findById(int idRec) throws SQLException ;
    public Utilisateur getUserById(int id);
    public void sendSms(String toPhoneNumber, String messageText);
}
