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
        buffer = new byte[BUF_SIZE];
        socket = new DatagramSocket(this.port);
        packet = new DatagramPacket(buffer, BUF_SIZE);
    }
    

    public String Listen()
    {
        try
        {
            socket.receive(packet);          
            this.clienthost = packet.getAddress();
            this.clientport = packet.getPort();
            System.out.println(clienthost + " " + clientport);
            bais = new ByteArrayInputStream(buffer);
            ois = new ObjectInputStream(bais);
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
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject((Object)data);
            oos.flush();
            buffer = baos.toByteArray();
            System.out.println(buffer.length);
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
