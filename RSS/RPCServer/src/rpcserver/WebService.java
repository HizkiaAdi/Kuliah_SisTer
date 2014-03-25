package rpcserver;

/**
 *
 * @author Voron
 */

@javax.jws.WebService(endpointInterface = "rpcserver.IWebService")
public class WebService implements IWebService
{

    @Override
    public Object getGempaTerkini()
    {
        return null;
    }
    
}
