package com.example.demo.controller;

import com.example.demo.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class FileController {
    
    private final FileService fileService;

    @GetMapping("/readFile") 
    public ResponseEntity<String> readFile() {
        log.debug("[readFile][BEGIN]");

        fileService.readFile();
        
        log.debug("[readFile][END]");
        return ResponseEntity.ok().body("OK");
    }

}
