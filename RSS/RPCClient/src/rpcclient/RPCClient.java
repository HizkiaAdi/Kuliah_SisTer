
package rpcclient;

/**
 *
 * @author Voron
 */

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import rpcserver.IWebService;
import SerializeableObject.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RPCClient
{   
    static byte[] buffer;
    static ByteArrayInputStream bais;
    static ObjectInputStream ois;
    
    static URL url;
    static QName qname;
    static Service service;
    static IWebService wsObject;
    static Scanner scanner;
    
    public static void main(String[] args) throws MalformedURLException, IOException, ClassNotFoundException
    {
        url = new URL("http://localhost:9999/ws/RPC?wsdl");
        qname = new QName("http://rpcserver/", "WebServiceService");
        
        service = Service.create(url, qname);
        wsObject = service.getPort(IWebService.class);
        
        scanner = new Scanner(System.in);
        int param = 0;
        while(param != 6)
        {
            System.out.println("pilihan:\n1. gempa terkini\n2. cuaca indonesia\n"
                    + "3. aviation observation\n6. keluar");
            param = Integer.parseInt(scanner.nextLine());
            
            switch(param)
            {
                case 1:
                    displayGempa();
                    break;
                case 2:
                    displayCuacaIndonesia();
                    break;
                case 3:
                    displayAviationObservation();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
        scanner.close();
    }
    
    public static void displayGempa() throws  IOException, ClassNotFoundException
    {
        ArrayList<Gempa> gempa;
                        
        buffer = wsObject.getGempaTerkini();
        if(buffer.length == 1)
        {
            System.err.println("ERROR: Error in webservice!");
            return;
        }
        bais = new ByteArrayInputStream(buffer);
        ois = new ObjectInputStream(bais);
        ois.read(buffer);
        gempa = (ArrayList<Gempa>)ois.readObject();
        
        for(Gempa i : gempa)
        {
            System.out.println(i.toString() + "\n");
        }
    }
    
    public static void displayCuacaIndonesia() throws IOException, ClassNotFoundException
    {
        ArrayList<Cuaca> cuaca;
                        
        buffer = wsObject.getCuacaIndonesia();
        if(buffer.length == 1)
        {
            System.err.println("ERROR: Error in webservice!");
            return;
        }
        bais = new ByteArrayInputStream(buffer);
        ois = new ObjectInputStream(bais);
        ois.read(buffer);
        cuaca = (ArrayList<Cuaca>)ois.readObject();
        
        for(Cuaca i : cuaca)
        {
            System.out.println(i.toString() + "\n");
        }
    }
    
    public static void displayAviationObservation() throws IOException, ClassNotFoundException
    {
        ArrayList<Aviation> aviation;
        
        buffer = wsObject.getAviationObservation();
        if(buffer.length == 1)
        {
            System.err.println("ERROR: Error in webservice!");
            return;
        }
        bais = new ByteArrayInputStream(buffer);
        ois = new ObjectInputStream(bais);
        ois.read(buffer);
        aviation = (ArrayList<Aviation>)ois.readObject();
        
        for(Aviation i : aviation)
        {
            System.out.println(i.toString() + "\n");
        }
    }
}
