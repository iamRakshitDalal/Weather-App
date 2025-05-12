package com.weatherapp.weatherapp.model;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private String Date;
    private int temp;
    private String weatherDis;
    private int humidity;
    private double windSpeed;

    @JsonProperty("weather[0].main")
    public void unPackWeather(String weatherDis){
        this.weatherDis = weatherDis;
    }

    @JsonProperty("main")
    public void unPackMain(Map<String,Object> main){
        this.temp = (int)((double)main.get("temp")-273);
        this.humidity = (int)main.get( "humidity");
    }

    @JsonProperty( "wind.speed")
    public void unPackWindSpeed(int speed){
        this.windSpeed = (int)speed;
    }

    @JsonProperty("dt")
    public void unPackdate(long date){
        this.Date = new Date(date*1000).toString();
    }

    @JsonProperty("name")
    public void unPackCityName(String name){
        this.city  = name;
    }

    
}