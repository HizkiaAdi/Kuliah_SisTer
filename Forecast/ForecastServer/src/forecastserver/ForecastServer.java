package forecastserver;

/**
 *
 * @author Voron
 */

import SerializableObject.ForecastData;
import java.io.IOException;
import java.util.List;

public class ForecastServer
{
    static ClientHandler handler;
    static List<ForecastData> dataList;
    
    public static void main(String[] args)
    {
        String param;
        
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
            param = handler.Listen();
            if(param != null)
            {
                
                
                handler.Send(dataList);
            }
            else
            {
                continue;
            }
        }
    }
    
    public static List<ForecastData> findByDate(ForecastData param)
    {
        
    }
    
    public static List<ForecastData> findByDay(ForecastData param)
    {
        
    }
    
    public static List<ForecastData> findByWeather(ForecastData param)
    {
        
    }
    
    public static void ServerInit()
    {
        dataList.add(new ForecastData("10-03-2014", "senin", "mendung"));
        dataList.add(new ForecastData("11-03-2014", "selasa", "cerah"));
        dataList.add(new ForecastData("12-03-2014", "rabu", "hujan badai"));
        dataList.add(new ForecastData("13-03-2014", "kamis", "berawan"));
        dataList.add(new ForecastData("14-03-2014", "jumat", "hujan"));
        dataList.add(new ForecastData("15-03-2014", "sabtu", "cerak"));
        dataList.add(new ForecastData("16-03-2014", "minggu", "hujan ringan"));        
    }
}
