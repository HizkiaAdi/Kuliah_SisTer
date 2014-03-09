/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sisterweatherforecast;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream;
import java.net.*;
import java.io.*;
import java.util.*;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import SerializableObject.ForecastData;


/**
 *
 * @author misbahul
 */
public class SisterWeatherClient {
    private int port;
    private String ipAdrress;
    private Scanner scan;
    private List<ForecastData> forecastData;
    public SisterWeatherClient(int port,String ipAdrress)
    {
        this.port=port;
        this.ipAdrress=ipAdrress;
    }
    public void StartClient() throws ClassNotFoundException, IOException
    { String input;
      Socket clientSocket;
      List<ForecastData> output;
       String outputPrint="";
        try {
            clientSocket= new Socket(ipAdrress, port);
            ObjectInputStream ois= new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos= new ObjectOutputStream(clientSocket.getOutputStream());
            while(true)
            {
              scan=new Scanner(System.in);
              input=scan.nextLine();
              oos.writeObject(input);
                    while((output=(List<ForecastData>)ois.readObject())!=null)
                    {
                        
                        for(ForecastData data:output)
                        {   
                          outputPrint=data.getForecastDay()+" "+data.getForecastDate()+" "+data.getForecastWeather();
                          System.out.print(outputPrint);
                           
                        }
                       

                    }
               }
            }
          
         catch (IOException ex) {
            Logger.getLogger(SisterWeatherClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
