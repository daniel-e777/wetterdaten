package de.wetterdaten_be.api;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    public <WeatherData> List<WeatherData> getWeather(double lat, double lon, String start, String end) {

        System.out.println("Frontend-Daten:");
        System.out.println("   LAT:  " + lat);
        System.out.println("   LON:  " + lon);
        System.out.println("   Von:  " + start);
        System.out.println("   Bis:  " + end);

        List<WeatherData> list = new ArrayList<>();
        list.add(new WeatherData(LocalDate.parse(start), 12.5));
        list.add(new WeatherData(LocalDate.parse(end), 14.7));

        return list;
    }
}
