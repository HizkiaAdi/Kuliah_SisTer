/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wildclient;

import SerializableObject.ForecastData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Wildhan Ibrahim
 */
public class Client {
    private int port;
    private String ipAdrs;
    private InetAddress inAdrs;
    private DatagramSocket dgSock;
    private DatagramPacket dgPack;
    private byte[] buff;
    private ByteArrayInputStream bais;
    private ByteArrayOutputStream baos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Scanner scan;
    private int BUF_SIZE = 1500;
    
    public Client(String ipAdrs, int port){
        this.port = port;
        this.ipAdrs = ipAdrs;
        this.buff = new byte[BUF_SIZE];
    }
    
    public void Start(){
        String input;
        while(true){
            System.out.println("Masukan nama hari atau ketik \"all\" untuk menampilkan semua :");
            scan = new Scanner(System.in);
            input = scan.next();
            Send(input);
            Receive();
        }
    }
    
    private void Send(String input){
        try {
            //buff = new byte[BUF_SIZE];
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            inAdrs = InetAddress.getByName(ipAdrs);
            oos.writeObject((Object)input);
            oos.flush();
            buff = baos.toByteArray();
            dgSock = new DatagramSocket();
            dgPack = new DatagramPacket(buff, buff.length, inAdrs, port);            
            dgSock.send(dgPack);
        } catch (IOException ex) {
            System.out.println("IO (Send) : "+ex.getMessage());
        }
    }
    
    private void Receive(){
        List<ForecastData> output;
        try{
            buff = new byte[BUF_SIZE];
            dgPack = new DatagramPacket(buff, 1500);
            dgSock.receive(dgPack);
            bais = new ByteArrayInputStream(buff);
            ois = new ObjectInputStream(bais);
            ois.read(buff);
            
            output = (List<ForecastData>)ois.readObject();
            System.out.println(buff.length);
            
            for(ForecastData outp:output){
                System.out.println(outp.getForecastDay()+" "+outp.getForecastDate()+" "+outp.getForecastWeather());
            }
            
        } catch (IOException ex) {
            System.out.println("IO (Receive) : "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found : "+ex.getMessage());
        }
    }
}
