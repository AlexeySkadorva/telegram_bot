import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

import java.io.IOException;

/**
 * @author Alexey Skadorva
 */
public class Weather {

    public String getTemperature() throws IOException {
        OpenWeatherMap owm = new OpenWeatherMap("bd5e378503939ddaee76f12ad7a97608");
        CurrentWeather cwd = owm.currentWeatherByCityName("Minsk");

        return "Температура сегодня в Минске : " + "от " + getTemperatureInCelsium(cwd.getMainInstance().getMinTemperature()) + " / до " +
                getTemperatureInCelsium(cwd.getMainInstance().getMaxTemperature()) + " C";
    }

    private float getTemperatureInCelsium(float temperature) {
        return (temperature - 32) * 5 / 9;
    }
}
