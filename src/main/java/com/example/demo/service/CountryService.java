package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.example.demo.repository.CountryRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public void cleanCountries() {
        log.debug("[cleanCountries][BEGIN]");
    
        countryRepository.deleteAll();

        log.debug("[cleanCountries][END]");
    }

}
