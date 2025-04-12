package com.example.demo.controller;

import org.oorsprong.websamples.ArrayOftCurrency;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@ApiResponses({
        @ApiResponse(responseCode = "404", content = { @Content(mediaType = MediaType.TEXT_PLAIN_VALUE) }),
        @ApiResponse(responseCode = "500", content = { @Content(mediaType = MediaType.TEXT_PLAIN_VALUE) })
})
public interface RestService {

    @GetMapping("/capital/{countryISOCode}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = MediaType.TEXT_PLAIN_VALUE) }),
    })

    public ResponseEntity<?> getCapital(@NonNull @PathVariable(name = "countryISOCode") String countryISOCode);

    @GetMapping("/currency")
    @Parameters(@Parameter(name = "sCurrencyISOCode", in = ParameterIn.QUERY, required = false))
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ArrayOftCurrency.class)) }),
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = String.class)) }) })

    public ResponseEntity<?> getCurrency(
            @RequestParam(name = "sCurrencyISOCode", required = false) String sCurrencyISOCode);

}
