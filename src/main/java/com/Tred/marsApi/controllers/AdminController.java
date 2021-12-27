package com.Tred.marsApi.controllers;

import com.Tred.marsApi.models.Martian;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mars")
public class AdminController {

    @GetMapping("/martians")
    public ResponseEntity<List<Martian>>getMartians(){
        return null;
    }
}
