package com.example.demo.config;

import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {

    @Bean
    CountryInfoServiceSoapType getCountryInfoService(){
        return new CountryInfoService().getCountryInfoServiceSoap();
    }
    
}