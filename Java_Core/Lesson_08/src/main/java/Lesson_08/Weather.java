package Lesson_08;

public class Weather {
    String city;
    String localDate;
    String weatherText;
    Double temperature;

    @Override
    public String toString(){
        return "[" + city + ", " + localDate + ", " + weatherText + ", " + temperature + "]";
    }
}
