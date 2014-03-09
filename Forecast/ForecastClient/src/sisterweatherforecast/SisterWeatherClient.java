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
import static java.util.Collections.list;


/**
 *
 * @author misbahul
 */
public class SisterWeatherClient {
    private int port;
    private String ipAdrress;
    private Scanner scan;
    private DatagramSocket dgSocket;
    private DatagramPacket packet;
    private List<ForecastData> forecastData;
    private byte[] buffer;
    private InetAddress adrres;
    private int buffersize=1500;
    private ByteArrayOutputStream baos;
    private ByteArrayInputStream bais;
    private  ObjectInputStream ois;
    private ObjectOutputStream oos;
    public SisterWeatherClient(int port,String ipAdrress)
    {
        this.port=port;
        this.ipAdrress=ipAdrress;
    }
    public void StartClient() throws ClassNotFoundException, IOException
    { String input;
      Socket clientSocket;
      adrres= InetAddress.getByName(ipAdrress);
      List<ForecastData> output;
       String outputPrint="";
        try {
            //clientSocket= new Socket(ipAdrress, port);
            dgSocket= new DatagramSocket();
            packet= new DatagramPacket(buffer,buffersize,adrres, port); 
            baos = new ByteArrayOutputStream();
            bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois= new ObjectInputStream(bais);
            ObjectOutputStream oos= new ObjectOutputStream(baos);
            while(true)
            {
 
             
              System.out.print("Massukan Perintah :");
              scan=new Scanner(System.in);
              input=scan.next();
              SendData(input);
                    while(true)
                    {
                        if((output=ReceiveData())!=null)
                        {
                            for(ForecastData data:output)
                            {   
                              outputPrint=data.getForecastDay()+" "+data.getForecastDate()+" "+data.getForecastWeather();
                              System.out.print(outputPrint);

                            }
                        }
                       

                    }
               }
            }
          
         catch (IOException ex) {
            Logger.getLogger(SisterWeatherClient.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    } 
    public List<ForecastData> ReceiveData()
    {  List<ForecastData> data;
        try
        {
            dgSocket = new DatagramSocket(this.port);
            packet = new DatagramPacket(buffer, buffersize);
            dgSocket.receive(packet);           
            ois.read(buffer);
            data = (List<ForecastData>)ois.readObject();
            
            return data;
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println(ex);
            return null;
        }

        
    }
    
    public void SendData(String data)
    {
      try
        {
            oos.writeObject((Object)data);
            buffer = baos.toByteArray();
            packet = new DatagramPacket(buffer, buffer.length, adrres, port);
            dgSocket.send(packet);
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            
        }

    }
       
}
