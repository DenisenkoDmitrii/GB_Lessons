package Lesson_08;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/*
Lesson_08 (GB.Java Core)
Denisenko Dmitriy (21.11.2021)
 */
public class Lesson_08 {
    public static void main(String[] args) throws IOException, SQLException {
        String city = "Volzhsky";
        String cityCode = WeatherResponse.detectCityCode(city);
        String forecast = WeatherResponse.getWeather(cityCode);
        //System.out.println(forecast);
        File file = new File("weather.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = new Weather();
        weather.city = city;
        weather.localDate = objectMapper.readTree(file).at("/DailyForecasts/0/Date").asText();
        weather.weatherText = objectMapper.readTree(file).at("/Headline/Text").asText();
        Double tMin, tMax;
        tMin = objectMapper.readTree(file).at("/DailyForecasts/0/Temperature/Minimum/Value").asDouble();
        tMax = objectMapper.readTree(file).at("/DailyForecasts/0/Temperature/Maximum/Value").asDouble();
        weather.temperature = (tMax + tMin) / 2;
        //System.out.println(weather.toString());
        DbHandler dbHandler = new DbHandler();
        dbHandler.addWeather(weather);
        System.out.println(dbHandler.findAllWeather());
    }
}

