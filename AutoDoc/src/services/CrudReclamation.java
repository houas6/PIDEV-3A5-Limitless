/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import BD.MyConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author achra
 */
public class CrudReclamation implements InterfaceService{
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
        
    
    @Override
    public void ajouterreclamation(reclamations r) {
    try {
        System.out.println("/////////");
        System.out.println(conn);
        System.out.println("/////////");
        ste = conn.createStatement();
        String req = "INSERT INTO `gestion des reclamations` VALUES(0,"+r.getid_client()+",'"+r.getDescription()+"','"+r.getEtat()+"')";
        System.out.println(req);
        ste.executeUpdate(req);
        System.out.println("reclamation ajouté");
    } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Reclamation non ajouté!!!!");    }
    }
    
    @Override
    public List<reclamations> afficherreclamation() {
        List<reclamations> pers = new ArrayList<>();
        try {
        String req = "SELECT * FROM `gestion des reclamations`";
        ste = conn.createStatement();
        ResultSet result = ste.executeQuery(req);
        System.out.println(result);
        while (result.next()) {
            reclamations resultPerson = new reclamations(result.getInt("id"), result.getInt("id_client"), result.getString("description"),result.getString("etat"));
            pers.add(resultPerson);
        }
        System.out.println(pers);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return pers;
 }
    
    
    public void modifierreclamation(reclamations r) {
        try {
            String req = "UPDATE `gestion des reclamations` SET `id_client` = '" + r.getid_client() + "', `description` = '" + r.getDescription() + "',`etat` = '" + r.getEtat() + "' WHERE `gestion des reclamations`.`id` = " + r.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamtion updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        public void supprimerreclamation(int id) {
        try {
            String req = "DELETE FROM `gestion des reclamations` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterpersonne2(reclamations r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierpersonne(reclamations r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerpersonne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getid (int n ){ 
    int t=0 ; 
    try {
            String requete = "select * from reclamations where ?= id";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, n);
            ResultSet e = pst.executeQuery();
            while(e.next()){
            reclamations rec = new reclamations(); 
            
            rec.setId(e.getInt("id"));
            t=rec.getId();   }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
   
return t ; 
    }
    private static final String ACCOUNT_SID = "AC5cb58b736e27631e4fe045ce72164118";
  private static final String AUTH_TOKEN = "6c4464f3d3acaf9d354b4d8b2a0d9a01";
  private static final String TWILIO_PHONE_NUMBER = "+12766336168";

  // Define the method to send the SMS message
  @Override
  public void sendSms(String toPhoneNumber, String messageText) {
    // Initialize the Twilio API client
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    // Set the phone numbers for the SMS message
    PhoneNumber to = new PhoneNumber(toPhoneNumber);
    PhoneNumber from = new PhoneNumber(TWILIO_PHONE_NUMBER);

    // Use the Message creator to send the SMS message
    Message message = Message.creator(to, from, messageText).create();
  }
    
//    @Override
//    public void sendsmsTextloc() {
//try {
//            // Construct data
//            String apiKey = "apikey=" + "AC5cb58b736e27631e4fe045ce72164118";
//            String message = "&message=" + "Greetings from Simplifying Tech! Have a nice day!";
////            String sender = "&sender=" + "TXTLCL";
//            String numbers = "&numbers=" + "+21695337153";
// 
//            // Send data
//           System.out.println("//////////");
//            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
//            System.out.println(conn);
//            System.out.println("111111111111");
//            String data = apiKey + numbers + message;
//            conn.setDoOutput(true);
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//            conn.getOutputStream().write(data.getBytes("UTF-8"));
//            System.out.println("222222222222222"); 
//            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuffer stringBuffer = new StringBuffer();
//            String line;
//            System.out.println("33333333333");
//            while ((line = rd.readLine()) != null) {
//                System.out.println(line);
//                stringBuffer.append(line).append("\n");
//            }
//            System.out.println(stringBuffer.toString());
//            rd.close();
// 
// 
//        } catch (Exception e) {
//           e.printStackTrace();
//           System.out.println(e);
//        }
//    }   

    
}
    

