package forecastserver;

/**
 *
 * @author Voron
 */

import java.net.*;
import SerializableObject.ForecastData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientHandler
{
    private DatagramSocket socket;
    private DatagramPacket packet;
    private int port;
    private ForecastData data;
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
    

    public ForecastData Listen()
    {
        try
        {
            socket = new DatagramSocket(this.port);
            packet = new DatagramPacket(buffer, BUF_SIZE);
            socket.receive(packet);            
            this.clienthost = socket.getInetAddress();
            this.clientport = socket.getPort();
            
            ois.read(buffer);
            data = (ForecastData)ois.readObject();
            
            return data;
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    
    public boolean Send(ForecastData data)
    {
        try
        {
            this.data = data;
            oos.writeObject((Object)data);
            buffer = baos.toByteArray();
            packet = new DatagramPacket(buffer, buffer.length, clienthost, clientport);
            
            return true;
        }
        catch(IOException ex)
        {
            System.out.println(ex);
            return false;
        }
    }
}
