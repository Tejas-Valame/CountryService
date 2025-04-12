package com.example.demo.controller;

import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestServiceImpl implements RestService {

    private final CountryInfoServiceSoapType service;

    @Override
    public ResponseEntity<?> getCapital(@NonNull String countryISOCode) {

        ResponseEntity<?> response;
        String capital;

        log.debug("Searching capital for country {}", countryISOCode);

        if (countryISOCode == null || countryISOCode.strip().isEmpty()) {
            response = ResponseEntity.internalServerError().body("Country Code cannot be null or empty");
        } else {
            capital = service.capitalCity(countryISOCode);
            log.info("getCapital API returned response \"{}\" for country: {}", capital, countryISOCode);

            if ("Country not found in the database".equalsIgnoreCase(capital.strip())) {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(capital);
            } else {
                response = ResponseEntity.ok().body(capital);
            }
        }

        log.debug("Returning response \"{}\" with HTTP Status Code: {}", response.getBody(), response.getStatusCode());
        return response;
    }

    @Override
    public ResponseEntity<?> getCurrency(String sCurrencyISOCode) {

        ResponseEntity<?> response;
        String currency;

        if (sCurrencyISOCode == null || sCurrencyISOCode.strip().isEmpty()) {
            response = ResponseEntity.ok().body(service.listOfCurrenciesByName());
        } else {
            currency = service.currencyName(sCurrencyISOCode);
            if ("Currency code NOT found".equalsIgnoreCase(currency.strip())) {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(currency);
            } else {
                response = ResponseEntity.ok().body(currency);
            }
        }
        log.debug("Returning response \"{}\" with HTTP Status Code: {}", response.getBody(), response.getStatusCode());
        return response;

    }
}
