
package rpcserver;

/**
 *
 * @author Voron
 */

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import SerializeableObject.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser
{
    private static NodeList nodes;
    private static NodeList childs;
    
    private static DocumentBuilderFactory dbf;
    private static DocumentBuilder db;
    private static Document doc;
    
    private static Boolean isLocal = false;
    
    public static ArrayList<Gempa> getGempa() throws ParserConfigurationException, SAXException, IOException
    {
        ArrayList<Gempa> gempa = new ArrayList<Gempa>();
        
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        if(isLocal)
            doc = db.parse(new File("C:\\Users\\Voron\\Desktop\\gempaterkini.xml"));
        else
            doc = db.parse(new URL("http://data.bmkg.go.id/gempaterkini.xml").openStream());
        
        nodes = doc.getDocumentElement().getElementsByTagName("gempa");
        
        for(int x = 0; x < nodes.getLength(); x++)
        {
            childs = nodes.item(x).getChildNodes();
            if(childs.getLength() < 17)
                continue;
            gempa.add(new Gempa(childs.item(1).getTextContent(),
                    childs.item(3).getTextContent(),
                    childs.item(7).getTextContent(),
                    childs.item(9).getTextContent(),
                    childs.item(11).getTextContent(),
                    childs.item(13).getTextContent(),
                    childs.item(17).getTextContent()));
        }
                
        return gempa;
    }
    
    public static ArrayList<Cuaca> getCuacaIndonesia() throws ParserConfigurationException, SAXException, IOException
    {
        ArrayList<Cuaca> cuaca = new ArrayList<Cuaca>();
        
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        if(isLocal)
            doc = db.parse(new File("C:\\Users\\Voron\\Desktop\\cuaca_indo_1.xml"));
        else
            doc = db.parse(new URL("http://data.bmkg.go.id/cuaca_indo_1.xml").openStream());
        
        nodes = doc.getDocumentElement().getElementsByTagName("Isi");
        nodes = nodes.item(0).getChildNodes();
        for(int x = 0; x < nodes.getLength(); x++)
        {
            childs = nodes.item(x).getChildNodes();
            if(childs.getLength() < 10)
                continue;
            cuaca.add(new Cuaca(childs.item(0).getTextContent(),
                    childs.item(2).getTextContent(),
                    Integer.parseInt(childs.item(4).getTextContent()),
                    Integer.parseInt(childs.item(6).getTextContent()),
                    Integer.parseInt(childs.item(8).getTextContent()),
                    Integer.parseInt(childs.item(10).getTextContent())));
        }
        
        return cuaca;
    }
    
    public static ArrayList<Aviation> getAviationObservation() throws ParserConfigurationException, SAXException, IOException
    {
        ArrayList<Aviation> aviation = new ArrayList<Aviation>();
        
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        if(isLocal)
            doc = db.parse(new File("C:\\Users\\Voron\\Desktop\\aviation_observation.xml"));
        else
            doc = db.parse(new URL("http://data.bmkg.go.id/aviation_observation.xml").openStream());
        
        nodes = doc.getDocumentElement().getElementsByTagName("report");
        
        for(int x = 0; x < nodes.getLength(); x++)
        {
            
            childs = nodes.item(x).getChildNodes();
            if(childs.getLength() < 42)
                continue;
            aviation.add(new Aviation(childs.item(1).getTextContent(),
                    childs.item(3).getTextContent(),
                    childs.item(5).getTextContent(),
                    childs.item(7).getTextContent(),
                    childs.item(9).getTextContent(),
                    childs.item(11).getTextContent(),
                    childs.item(13).getTextContent(),
                    childs.item(15).getTextContent(),
                    childs.item(17).getTextContent(),
                    childs.item(19).getTextContent(),
                    childs.item(21).getTextContent(),
                    childs.item(23).getTextContent(),
                    childs.item(25).getTextContent(),
                    childs.item(27).getTextContent(),
                    childs.item(29).getTextContent(),
                    childs.item(31).getTextContent(),
                    childs.item(33).getTextContent(),
                    childs.item(35).getTextContent(),
                    childs.item(37).getTextContent(),
                    childs.item(39).getTextContent(),
                    childs.item(41).getTextContent(),
                    childs.item(42).getTextContent()
                    ));
        }
        
        return aviation;
    }
}
