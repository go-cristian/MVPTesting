package co.iyubinest.weatherapp.weather.domain;

/**
 * Created by cristiangomez on 14/10/15.
 */
public class Weather
{

    private final String city;

    private final String value;

    private final String status;

    public Weather (String city, String value, String status)
    {
        this.city = city;
        this.value = value;
        this.status = status;
    }

    public String getCity ()
    {
        return city;
    }

    public String getStatus ()
    {
        return status;
    }

    public String getValue ()
    {
        return value;
    }
}
