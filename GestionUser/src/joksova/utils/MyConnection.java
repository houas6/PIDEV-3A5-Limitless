/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joksova.utils;

import java.sql.*;

/**
 *
 * @author hasse
 */
public class MyConnection {

    Connection conn;

    String url = "jdbc:mysql://localhost:3306/limitless";
    String user = "root";
    String pwd = "";    

    public MyConnection() {
        
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        }
        
        catch(SQLException ex) {
            System.out.println("connexion non etablie");
        }
    }       
    
    public Connection getCnx()
    {
    return conn;
    }
}
