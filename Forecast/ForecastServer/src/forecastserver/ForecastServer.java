package forecastserver;

/**
 *
 * @author Voron
 */

import SerializableObject.ForecastData;

public class ForecastServer
{
    static ClientHandler handler;
    
    public static void main(String[] args)
    {
        ForecastData data;
        
        if(args.length == 0)
            handler = new ClientHandler(1234);
        else
            handler = new ClientHandler(Integer.parseInt(args[0]));
        
        while(true)
        {
            if(handler.Listen())
            {
                data = new ForecastData(null, null, null);
                handler.Send();
            }
            else
            {
                continue;
            }
        }
    }
}
