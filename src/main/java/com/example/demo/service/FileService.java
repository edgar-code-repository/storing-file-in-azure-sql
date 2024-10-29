package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
    
    @Value("${sales.file.fullPath}")
    private String salesFilePath;
    
    public void readFile() {
        log.debug("[readFile][BEGIN]");

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(salesFilePath))) {
            String line;
            String[] lineArray;
            while ((line = br.readLine()) != null) {
                lineArray = line.split(",");
                
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
