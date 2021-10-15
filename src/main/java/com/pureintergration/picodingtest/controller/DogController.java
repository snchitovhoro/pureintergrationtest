package com.pureintergration.picodingtest.controller;

import com.pureintergration.picodingtest.service.DogService;
import com.pureintergration.picodingtest.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/breeds/list/all")
public class DogController {
    @Autowired
    IDogService dogService;
    @GetMapping public ResponseEntity<?> getAll(){
       return new ResponseEntity<>(dogService.getall(), HttpStatus.OK);
    }

}
