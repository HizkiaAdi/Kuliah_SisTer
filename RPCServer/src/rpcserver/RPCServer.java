package rpcserver;

/**
 *
 * @author Voron
 */

import javax.xml.ws.Endpoint;

public class RPCServer
{
    static String host = "http://localhost:9999/ws/RPC";
    
    public static void main(String[] args)
    {
        Endpoint.publish(host, new WebService());
        System.out.println("Server started at: " + host);
        System.out.println("WSDL at: " + host + "?wsdl");
    }
}
