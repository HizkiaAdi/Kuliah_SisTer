package forecastserver;

/**
 *
 * @author Voron
 */

import SerializableObject.ForecastData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ForecastServer
{
    static ClientHandler handler;
    static List<ForecastData> dataList;
    static List<ForecastData> data;
    
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
            data.clear();
            
            if(param != null)
            {
                if(param.equals("all"))
                {
                    data = new ArrayList<>(dataList);
                }
                else
                {
                    find(param.toLowerCase());
                }
                
                handler.Send(data);
            }
            else
            {
                continue;
            }
        }
    }
    
    public static void find(String param)
    {       
        for(ForecastData i:dataList)
        {
            if(i.getForecastDate().equals(param) || i.getForecastDay().equals(param) ||
                    i.getForecastWeather().equals(param))
            {
                data.add(i);
            }
        }
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
