/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hasse
 */
public class Config {
    
        private static String VerificationCode;

    public static String getVerificationCode() {
        return VerificationCode;
    }

    public static void setVerificationCode(String VerificationCode) {
        Config.VerificationCode = VerificationCode;
    }

    
}
