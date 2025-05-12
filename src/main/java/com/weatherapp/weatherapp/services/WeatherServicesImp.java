package com.weatherapp.weatherapp.services;


import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.weatherapp.weatherapp.model.WeatherData;

@Service
public class WeatherServicesImp implements WeatherServices {
    
    private String apiKey = "";
    private  RestTemplate restTemplate;

    WeatherServicesImp(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherData featchData(String city  ) {
        ResponseEntity<WeatherData> response= restTemplate.getForEntity(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s",city,apiKey),WeatherData.class); 
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        else{
            throw new RuntimeException("Failed to fetch weather data: " + response.getStatusCode());
        }
        
              
        
    }
    
    
}


