package rpcserver;

/**
 *
 * @author Voron
 */

import javax.xml.ws.Endpoint;

public class RPCServer
{
    public static void main(String[] args)
    {
        Endpoint.publish("http://localhost:9999/ws/RPC", new WebService());
    }
}
