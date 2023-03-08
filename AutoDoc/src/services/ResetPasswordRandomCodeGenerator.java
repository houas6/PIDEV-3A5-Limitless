/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author hasse
 */
public class ResetPasswordRandomCodeGenerator {


    public static String nextString() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
