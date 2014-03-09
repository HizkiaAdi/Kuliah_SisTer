package forecastserver;

/**
 *
 * @author Voron
 */

import SerializableObject.ForecastData;
<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> tambah forecast object

public class ForecastServer
{
    static ClientHandler handler;
    
    public static void main(String[] args)
    {
        ForecastData data;
        
<<<<<<< HEAD
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
=======
        try
        {
            if(args.length == 0)
                handler = new ClientHandler(1234);
            else
                handler = new ClientHandler(Integer.parseInt(args[0]));
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        
        while(true)
        {
            data = handler.Listen();
            if(data != null)
            {
                if(data.getForecastDate() != null)
                {
                }
                else if(data.getForecastDay() != null)
                {
                }
                else if(data.getForecastWeather() != null)
                {
                }
                
                data = new ForecastData(null, null, null);
                handler.Send(data);
>>>>>>> tambah forecast object
            }
            else
            {
                continue;
            }
        }
    }
}
