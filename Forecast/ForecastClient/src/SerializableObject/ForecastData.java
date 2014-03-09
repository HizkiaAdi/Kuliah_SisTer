/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SerializableObject;
import java.io.Serializable;
/**
 *
 * @author misbahul
 */
public class ForecastData implements Serializable{
    private static final long  serialVersionUID=1L;
    private String forecastDay;
    private String forecastDate;
    private String forecastWeather;
    /**
     * @return the forecastDay
     */
    public String getForecastDay() {
        return forecastDay;
    }

    /**
     * @param forecastDay the forecastDay to set
     */
    public void setForecastDay(String forecastDay) {
        this.forecastDay = forecastDay;
    }

    /**
     * @return the forecastDate
     */
    public String getForecastDate() {
        return forecastDate;
    }

    /**
     * @param forecastDate the forecastDate to set
     */
    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    /**
     * @return the forecastWeather
     */
    public String getForecastWeather() {
        return forecastWeather;
    }

    /**
     * @param forecastWeather the forecastWeather to set
     */
    public void setForecastWeather(String forecastWeather) {
        this.forecastWeather = forecastWeather;
    }

    public  ForecastData(String forecastDate,String forecastDay, String forecastWeather)
    {
        this.forecastDate=forecastDate;
        this.forecastDay = forecastDay;
        this.forecastWeather=forecastWeather;
    }

    
}
