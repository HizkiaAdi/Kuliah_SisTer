/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.io.*;
import java.util.*;
import sun.misc.JavaxSecurityAuthKerberosAccess;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RmiClient
{
    static public void main(String args[]) throws ParserConfigurationException, SAXException, IOException
    {
       Scanner scan=new Scanner(System.in);
       RmiInterface rmiServer;
       Registry registry;
       String serverAddress=scan.nextLine();
       String serverPort=scan.nextLine();
       while(true)
       {
       String text=scan.nextLine();
       System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
       try{
           // get the �gregistry�h 
           registry=LocateRegistry.getRegistry(
               serverAddress,
               (new Integer(serverPort)).intValue()
           );
           // look up the remote object
           rmiServer=
              (RmiInterface)(registry.lookup("rmiServer"));
           // call the remote method
           rmiServer.receiveMessage(text);
           List<NodeList> listnode=rmiServer.RssFeed();
           for(NodeList childs:listnode)
           {
             System.out.println(childs.getLength());
             for(int i = 1; i < childs.getLength(); i += 2)
             System.out.println(childs.item(i).getTextContent());
           }
           
       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }
    }
    }
}
