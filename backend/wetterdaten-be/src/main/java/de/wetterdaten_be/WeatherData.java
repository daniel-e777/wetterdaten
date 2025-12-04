package de.wetterdaten_be;

import java.time.LocalDate;

public class WeatherData {

    private LocalDate date;
    private double temperature;

    public WeatherData(LocalDate date, double temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public LocalDate getDate() { return date; }
    public double getTemperature() { return temperature; }
}
