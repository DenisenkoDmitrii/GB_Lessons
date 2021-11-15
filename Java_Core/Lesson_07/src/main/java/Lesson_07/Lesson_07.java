package Lesson_07;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
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
        //System.out.println(forecast);
        ObjectMapper objectMapper = new ObjectMapper();
        String text = objectMapper.readTree(forecast).at("/Headline/Text").asText();
        System.out.println(text);
        String tMIN = objectMapper.readTree(forecast).at("/DailyForecasts/0/Temperature/Minimum/Value").asText();
        System.out.println("Минимальная температура: " + tMIN + " С");



        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Codebeautify codebeautify = objectMapper.readValue(forecast, Codebeautify.class);
        //System.out.println(codebeautify.getHeadline().getText());







    }
}
