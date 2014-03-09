package SerializableObject;

import java.util.Date;

/**
 *
 * @author Voron
 */
public class ForecastObject
{
    Date date;
    String day;
    String weather;
    
    public ForecastObject(Date date, String day, String weather)
    {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
    
    public Date getDate()
    {
        return this.date;
    }
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public String getDay()
    {
        return this.day;
    }
    
    public void setDay(String day)
    {
        this.day = day;
    }
    
    public String getWeather()
    {
        return this.weather;
    }
    
    public void setWeather(String weather)
    {
        this.weather = weather;
    }
}
