package SerializeableObject;

/**
 *
 * @author Voron
 */

import java.io.Serializable;

public class Aviation implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String IcaoID;
    private String WmoId;
    private String StationName;
    private String Latitude;
    private String Longitude;
    private String Elevation;
    private String TimeZone;
    private String ObservedTime;
    private String WindDegree;
    private String WindDegVar1;
    private String WindDegVar2;
    private String WindDir;
    private String WindSpeed;
    private String WindSpeedMax;
    private String Visibility;
    private String VisibilityDir;
    private String Weather;
    private String Cloud;
    private String VerVisibility;
    private String Temp;
    private String DewPoint;
    private String pressure;

    public Aviation(String IcaoID, String WmoId, String StationName,
            String Latitude, String Longitude, String Elevation, String TimeZone,
            String ObservedTime, String WindDegree, String WindDegVar1, String WindDegVar2,
            String WindDir, String WindSpeed, String WindSpeedMax, String Visibility,
            String VisibilityDir, String Weather, String Cloud, String VerVisibility,
            String Temp, String DewPoint, String pressure) {
        this.IcaoID = IcaoID;
        this.WmoId = WmoId;
        this.StationName = StationName;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Elevation = Elevation;
        this.TimeZone = TimeZone;
        this.ObservedTime = ObservedTime;
        this.WindDegree = WindDegree;
        this.WindDegVar1 = WindDegVar1;
        this.WindDegVar2 = WindDegVar2;
        this.WindDir = WindDir;
        this.WindSpeed = WindSpeed;
        this.WindSpeedMax = WindSpeedMax;
        this.Visibility = Visibility;
        this.VisibilityDir = VisibilityDir;
        this.Weather = Weather;
        this.Cloud = Cloud;
        this.VerVisibility = VerVisibility;
        this.Temp = Temp;
        this.DewPoint = DewPoint;
        this.pressure = pressure;
    }

    public String getIcaoID() {
        return IcaoID;
    }

    public String getWmoId() {
        return WmoId;
    }

    public String getStationName() {
        return StationName;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getElevation() {
        return Elevation;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public String getObservedTime() {
        return ObservedTime;
    }

    public String getWindDegree() {
        return WindDegree;
    }

    public String getWindDegVar1() {
        return WindDegVar1;
    }

    public String getWindDegVar2() {
        return WindDegVar2;
    }

    public String getWindDir() {
        return WindDir;
    }

    public String getWindSpeed() {
        return WindSpeed;
    }

    public String getWindSpeedMax() {
        return WindSpeedMax;
    }

    public String getVisibility() {
        return Visibility;
    }

    public String getVisibilityDir() {
        return VisibilityDir;
    }

    public String getWeather() {
        return Weather;
    }

    public String getCloud() {
        return Cloud;
    }

    public String getVerVisibility() {
        return VerVisibility;
    }

    public String getTemp() {
        return Temp;
    }

    public String getDewPoint() {
        return DewPoint;
    }

    public String getPressure() {
        return pressure;
    }
    
    @Override
    public String toString()
    {
        return "ICAO ID: " + getIcaoID() + "\n" +
                "WMO ID: " + getWmoId() + "\n" +
                "Station Name: " + getStationName() + "\n" +
                "Latitude: " + getLatitude() + "\n" +
                "Longitude: " + getLongitude() + "\n" +
                "Elevation: " + getElevation() + "\n" +
                "Time Zone: GMT+" + getTimeZone() + "\n" +
                "Observed Time: " + getObservedTime() + "\n" +
                "Wind Degree: " + getWindDegree() + "\n" +
                "Wind Degree Variation 1: " + getWindDegVar1() + "\n" +
                "Wind Degree Variation 2: " + getWindDegVar2() + "\n" +
                "Wind Direction: " + getWindDir() + "\n" +
                "Wind Speed: " + getWindSpeed() + "\n" +
                "Wind Speed Max: " + getWindSpeedMax() + "\n" +
                "Visibility: " + getVerVisibility() + "\n" +
                "Visibility Direction: " + getVisibilityDir() + "\n" +
                "Vertical Visibility: " + getVerVisibility() + "\n" +
                "Temperature: " + getTemp() + "\n" +
                "Dew Point: " + getDewPoint() + "\n" +
                "Pressure: " + getPressure() + "\n";
    }
}
