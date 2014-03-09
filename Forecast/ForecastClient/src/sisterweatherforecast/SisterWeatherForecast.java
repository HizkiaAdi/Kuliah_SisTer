/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sisterweatherforecast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author misbahul
 */
public class SisterWeatherForecast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan;
        scan= new Scanner(System.in);
        SisterWeatherClient client= new SisterWeatherClient(1234,"10.151.40.49");
        try {
            client.StartClient();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SisterWeatherForecast.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SisterWeatherForecast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
