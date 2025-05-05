package com.weatherapp.weatherapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherapp.weatherapp.model.WeatherData;
import com.weatherapp.weatherapp.services.WeatherServices;



@Controller
public class WeatherController {
    private WeatherServices weatherServices;

    WeatherController(WeatherServices weatherServices){
        this.weatherServices = weatherServices;
    }
    
    @GetMapping("/mausam")
    public String getMethodName(@RequestParam String city, Model model ) {
        WeatherData data = weatherServices.featchData(city);
        model.addAttribute("data",data);
        return "weatherInfo";
    }
    
    
}