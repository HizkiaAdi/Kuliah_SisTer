/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmiserver;
import  java.rmi.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.*;
import org.xml.sax.SAXException;
/**
 *
 * @author iskandarthegre4t
 */
public interface RmiInterface extends Remote{

    /**
     *
     * @param x
     */
    void receiveMessage(String x) throws RemoteException;
    String sendMessage() throws RemoteException;
    List<NodeList> RssFeed() throws RemoteException, ParserConfigurationException, MalformedURLException, SAXException, IOException;
}
