package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CountryService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;
    
    @GetMapping("/clean")
    public ResponseEntity<String> clean() {
        log.debug("[clean][BEGIN]");

        countryService.cleanCountries();
        
        log.debug("[clean][END]");
        return ResponseEntity.ok().body("OK");
    }

}
