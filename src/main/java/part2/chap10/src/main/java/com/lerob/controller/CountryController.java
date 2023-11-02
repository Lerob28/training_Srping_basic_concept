package com.lerob.controller;


import com.lerob.dto.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/country")
public class CountryController {

    @GetMapping("/cameroon")
    public ResponseEntity<Country> cameroon() {
        Country cameroon = Country.of("Cameroon", 128);
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("continent", "africa")
            .header("capital", "[douala, yaoundé]")
            .header("favorite_activity", "drink beer")
            .body(cameroon);
    }

    @GetMapping("/senegal")
    public ResponseEntity<Country> senegal() {
        Country senegal = Country.of("Senegal", 160);
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("continent", "africa")
            .header("capital", "dakar")
            .header("favorite_activity", "Tech manufacture")
            .body(senegal);
    }

    @GetMapping("/mali")
    public ResponseEntity<Country> mali() {
        Country mali = Country.of("Mali", 93);
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("continent", "africa")
            .header("capital", "bamako")
            .header("favorite_activity", "agriculture")
            .body(mali);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> allCountry() {
        ResponseEntity<Country> cameroon = cameroon();
        ResponseEntity<Country> senegal = senegal();
        ResponseEntity<Country> mali = mali();

        return ResponseEntity
            .status(200)
            .body(List.of(
                Objects.requireNonNull(cameroon.getBody()),
                Objects.requireNonNull(senegal.getBody()),
                Objects.requireNonNull(mali.getBody()))
            );
    }

    @GetMapping
    public ResponseEntity<List<Country>> defaultCall() {
        return allCountry();
    }
}

