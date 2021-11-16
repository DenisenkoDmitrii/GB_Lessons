package Lesson_07;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

import java.io.File;
import java.io.IOException;

/*
Lesson_07 (GB.Java Core)
Denisenko Dmitriy (15.11.2021)
 */
public class Lesson_07 {
    // Выводить пользователю только текстовое описание погоды и температуру в градусах Цельсия.
    public static void main(String[] args) throws IOException {
        String cityCode = WeatherResponse.detectCityCode("Volzhsky");
        String forecast = WeatherResponse.getWeather(cityCode);
        System.out.println(forecast);

        // Вариант через readTree
        File file = new File("weather.json");
        ObjectMapper objectMapper = new ObjectMapper();
        String text = objectMapper.readTree(file).at("/Headline/Text").asText();
        System.out.println(text);
        String tMIN = objectMapper.readTree(file).at("/DailyForecasts/0/Temperature/Minimum/Value").asText();
        System.out.println("Минимальная температура: " + tMIN + " С");

        //Вариант распарсить (не заработал)
        //Headline codebeautify = objectMapper.readValue(new File("weather.json"), Headline.class);
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //System.out.println("Volzhsky");
        //System.out.println(codebeautify.getText());


    }
}
