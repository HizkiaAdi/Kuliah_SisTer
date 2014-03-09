package forecastserver;

/**
 *
 * @author Voron
 */

import java.net.*;
import SerializableObject.ForecastData;
import SerializableObject.ForecastObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ClientHandler
{
    private DatagramSocket socket;
    private DatagramPacket packet;
    private int port;
    private String param;
    private int clientport;
    private InetAddress clienthost;
    private ByteArrayOutputStream baos;
    private ByteArrayInputStream bais;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private byte[] buffer;
    private int BUF_SIZE = 1500;    
    
    public ClientHandler(int port) throws IOException
    {
        this.port = port;
        baos = new ByteArrayOutputStream();
        bais = new ByteArrayInputStream(buffer);
        oos = new ObjectOutputStream(baos);
        ois = new ObjectInputStream(bais);
    }
    

    public String Listen()
    {
        try
        {
            socket = new DatagramSocket(this.port);
            packet = new DatagramPacket(buffer, BUF_SIZE);
            socket.receive(packet);            
            this.clienthost = socket.getInetAddress();
            this.clientport = socket.getPort();
            
            ois.read(buffer);
            param = (String)ois.readObject();
            
            return param;
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    
    public boolean Send(List<ForecastData> data)
    {
        try
        {
            oos.writeObject((Object)data);
            buffer = baos.toByteArray();
            packet = new DatagramPacket(buffer, buffer.length, clienthost, clientport);
            socket.send(packet);
            
            return true;
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            return false;
        }
    }
}
