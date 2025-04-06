package com.example.demo.controller;

import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestServiceImpl implements RestService{

        private final CountryInfoServiceSoapType service;

        @Override
        public ResponseEntity<?> getCapital(String countryISOCode) {
            return ResponseEntity.ok().body(service.capitalCity(countryISOCode));
        }
}
