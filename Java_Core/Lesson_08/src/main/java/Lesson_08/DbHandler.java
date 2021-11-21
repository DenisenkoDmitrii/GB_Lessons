package Lesson_08;

import org.sqlite.JDBC;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        connection = DriverManager.getConnection(PATH_DB);
    }

    Connection connection;

    public final String PATH_DB = "jdbc:sqlite:C:\\Java\\GB_Lessons\\Java_Core\\Lesson_08\\src\\main\\resources\\Weather.db";

    public void addWeather(Weather weather) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Weather('city', 'localDate', 'weatherText', 'temperature')" +
                        "VALUES(?, ?, ?, ?)"
        )) {
            statement.setObject(1, weather.city);
            statement.setObject(2, weather.localDate);
            statement.setObject(3, weather.weatherText);
            statement.setObject(4, weather.temperature);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Weather> findAllWeather() {
        List<Weather> weatherList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Weather");
            while (resultSet.next()) {
                Weather weather = new Weather();
                weather.city = resultSet.getString("city");
                weather.localDate = resultSet.getString("localDate");
                weather.weatherText = resultSet.getString("weatherText");
                weather.temperature = resultSet.getDouble("temperature");
                weatherList.add(weather);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weatherList;
    }
}
