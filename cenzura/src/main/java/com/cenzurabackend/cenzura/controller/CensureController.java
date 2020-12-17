package com.cenzurabackend.cenzura.controller;

import com.cenzurabackend.cenzura.service.CensureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CensureController {

    @Autowired
    CensureService censureService;

    @PostMapping("/censoring")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity censoring(@RequestParam String message){
        return new ResponseEntity(censureService.censoring(message), HttpStatus.OK);
    }
}
