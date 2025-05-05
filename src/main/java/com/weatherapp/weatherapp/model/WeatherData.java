package com.weatherapp.weatherapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private String Date;
    private int temp;
    private String weather;
    private int humidity;
    private double windSpeed;

    
    
}