package forecastserver;

/**
 *
 * @author Voron
 */

import SerializableObject.ForecastData;
import SerializableObject.ForecastObject;
import java.io.IOException;
import java.util.List;

public class ForecastServer
{
    static ClientHandler handler;
    static List<ForecastObject> dataList;
    
    public static void main(String[] args)
    {
        ForecastData data;
        
        ServerInit();
        
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
            }
            else
            {
                continue;
            }
        }
    }
    
    public static void ServerInit()
    {
        dataList.add(new ForecastObject("10-03-2014", "senin", "mendung"));
        dataList.add(new ForecastObject("11-03-2014", "selasa", "cerah"));
        dataList.add(new ForecastObject("12-03-2014", "rabu", "hujan badai"));
        dataList.add(new ForecastObject("13-03-2014", "kamis", "berawan"));
        dataList.add(new ForecastObject("14-03-2014", "jumat", "hujan"));
        dataList.add(new ForecastObject("15-03-2014", "sabtu", "cerak"));
        dataList.add(new ForecastObject("16-03-2014", "minggu", "hujan ringan"));        
    }
}
