package forecastserver;

/**
 *
 * @author Voron
 */

import SerializableObject.ForecastData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        dataList = new ArrayList<ForecastData>();
        data = new ArrayList<ForecastData>();
        
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
            param = handler.Listen().toLowerCase();
            System.out.println(param);
            data.clear();
            
            if(param != null)
            {
                if(param.equals("all"))
                {
                    data = new ArrayList<ForecastData>(dataList);
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
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File("forecast.txt")));
            
            for(String line; (line = br.readLine()) != null; )
            {
                String[] ar = line.split(",");
                dataList.add(new ForecastData(ar[0], ar[1], ar[2]));
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }
}
