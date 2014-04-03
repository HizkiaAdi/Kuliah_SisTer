package rpcserver;

/**
 *
 * @author Voron
 */

import SerializeableObject.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import org.xml.sax.SAXException;

@javax.jws.WebService(endpointInterface = "rpcserver.IWebService")
public class WebService implements IWebService
{
    ByteArrayOutputStream baos;
    ObjectOutputStream oos;
    byte[] buffer;

    @Override
    public byte[] getGempaTerkini()
    {
        ArrayList<Gempa> gempa = null;
        baos = new ByteArrayOutputStream();
                
        try
        {
            gempa = XMLParser.getGempa();
            oos = new ObjectOutputStream(baos);
            oos.writeObject((Object)gempa);
            oos.flush();
            buffer = baos.toByteArray();
        }
        catch(IOException | ParserConfigurationException | SAXException ex)
        {
            System.err.println(ex.getLocalizedMessage());
            return new byte[]{1};
        }
        finally
        {
            return buffer;
        }
    }
    
    @Override
    public byte[] getCuacaIndonesia()
    {
        ArrayList<Cuaca> cuaca = null;
        baos = new ByteArrayOutputStream();
                
        try
        {
            cuaca = XMLParser.getCuacaIndonesia();
            oos = new ObjectOutputStream(baos);
            oos.writeObject((Object)cuaca);
            oos.flush();
            buffer = baos.toByteArray();
        }
        catch(IOException | ParserConfigurationException | SAXException ex)
        {
            System.err.println(ex.getLocalizedMessage());
            return new byte[]{1};
        }
        finally
        {
            return buffer;
        }
    }
    
    @Override
    public byte[] getAviationObservation()
    {
        ArrayList<Aviation> aviation = null;
        baos = new ByteArrayOutputStream();
        
        try
        {
            aviation = XMLParser.getAviationObservation();
            oos = new ObjectOutputStream(baos);
            oos.writeObject((Object)aviation);
            oos.flush();
            buffer = baos.toByteArray();
        }
        catch(IOException | ParserConfigurationException | SAXException ex)
        {
            System.err.println(ex.getLocalizedMessage());
            return new byte[]{1};
        }
        finally
        {
            return buffer;
        }
    }
    
    @Override
    public byte[] getStasiun()
    {
        ArrayList<Stasiun> stasiun = null;
        baos = new ByteArrayOutputStream();
                
        try
        {
            stasiun = XMLParser.getStasiun();
            oos = new ObjectOutputStream(baos);
            oos.writeObject((Object)stasiun);
            oos.flush();
            buffer = baos.toByteArray();
        }
        catch(IOException | ParserConfigurationException | SAXException ex)
        {
            System.err.println(ex.getLocalizedMessage());
            return new byte[]{1};
        }
        finally
        {
            return buffer;
        }
    }
    
    @Override
    public byte[] getKoordinatKota()
    {
        ArrayList<Kota> kota = null;
        baos = new ByteArrayOutputStream();
                
        try
        {
            kota = XMLParser.getKoordinatKota();
            oos = new ObjectOutputStream(baos);
            oos.writeObject((Object)kota);
            oos.flush();
            buffer = baos.toByteArray();
            System.out.println("x");
        }
        catch(IOException | ParserConfigurationException | SAXException ex)
        {
            System.err.println(ex.getLocalizedMessage());
            return new byte[]{1};
        }
        finally
        {
            return buffer;
        }
    }
}
