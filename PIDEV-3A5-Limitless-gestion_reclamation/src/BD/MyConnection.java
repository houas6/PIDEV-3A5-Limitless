/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author achra
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection {
     private  Connection  conn;
   String url = "jdbc:mysql://127.0.0.1:3306/limitless";
   String user = "root";
   String pwd = "";
   private static MyConnection instance;
    private MyConnection() {
        
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie!!!");
        } catch (SQLException ex) {
            
            System.out.println("probleme de Connexion");  
            System.out.println(ex);
        }}

  public static MyConnection getInstance(){
        if (MyConnection.instance == null) {
            MyConnection.instance = new MyConnection();
        }
        System.out.println(MyConnection.instance);
        return MyConnection.instance;
        
    }
  public static Connection getConnection() {
        return MyConnection.getInstance().conn;
    }
    
    
    
}