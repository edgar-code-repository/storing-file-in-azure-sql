package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
    
    @Value("${file.countries.fullPath}")
    private String countriesFullPath;

    private final CountryRepository countryRepository;
    
    public void readFile() {
        log.debug("[readFile][BEGIN]");

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(countriesFullPath))) {
            String line;
            String[] lineArray;
            while ((line = br.readLine()) != null) {
                lineArray = line.split(";");

                Country country = new Country();
                country.setName(lineArray[1]);
                country.setCapital(lineArray[3]);
                country.setOfficialName(lineArray[2]);

                countryRepository.save(country);
                
                count++;
                log.debug("[readFile][count: {}]", count);
                log.debug("[readFile][line: {}]", line);
            }
        } catch (Exception e) {
            log.error("[readFile][error: {}]", e.toString());
        }

        log.debug("[readFile][END]");
    }

}
