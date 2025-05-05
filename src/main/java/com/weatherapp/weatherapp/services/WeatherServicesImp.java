package com.weatherapp.weatherapp.services;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherapp.weatherapp.model.WeatherData;

@Service
public class WeatherServicesImp implements WeatherServices {
    
    private String apiKey = "c95094e0677a8a7a608d853f2bdaf40a";
    private  RestTemplate restTemplate;

    WeatherServicesImp(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherData featchData(String city) {
        ResponseEntity<WeatherData> data = restTemplate.getForEntity(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s",city,apiKey),WeatherData.class); 
       
        return data.getBody();    
        
        
    }
    
    
}


