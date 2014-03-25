/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmiserver;
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author iskandarthegre4t
 */
public class Rmis extends java.rmi.server.UnicastRemoteObject implements RmiInterface{
    private String message;
    private int port;
    private String address;
    private Registry registry;
    public Rmis() throws RemoteException
    {
        try{
         address=(InetAddress.getLocalHost()).toString();
        }
        catch(Exception e)
        {
          throw new RemoteException("can't get inet address.");
        }
        this.port=8989;
        System.out.println("this address="+address+",port="+port);
        try{
           
        // create the registry and bind the name and object.
        registry = LocateRegistry.createRegistry( port );
            registry.rebind("rmiServer",this);
        }
        catch(RemoteException e){
        throw e;
        }
    }
    
    @Override
    public void receiveMessage(String x) throws RemoteException {
        System.out.println(x);//To change body of generated methods, choose Tools | Templates.
        message="dari server"+x;
    }

    @Override
    public String sendMessage() throws RemoteException {
        //To change body of generated methods, choose Tools | Templates.
        return message;
    }

    @Override
    public List<NodeList> RssFeed() throws RemoteException, ParserConfigurationException, MalformedURLException, SAXException, IOException {
        NodeList nodes;
        NodeList childs;
        List<NodeList> listnode= new ArrayList<NodeList>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL("http://data.bmkg.go.id/gempaterkini.xml").openStream());
        nodes = doc.getDocumentElement().getElementsByTagName("gempa");
        for(int c=0;c<5;c++)
        {
             childs = nodes.item(c).getChildNodes();
             listnode.add(childs);
             
        }
        return  listnode;
    }

    
}
