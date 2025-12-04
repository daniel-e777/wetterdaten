package de.wetterdaten_be.api;

import de.wetterdaten_be.WeatherData;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    private final WeatherService service;

    public WeatherController( WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public List<WeatherData> getWeather(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam String start,
            @RequestParam String end
    ) {
        return service.getWeather(lat, lon, start, end);
    }
}
