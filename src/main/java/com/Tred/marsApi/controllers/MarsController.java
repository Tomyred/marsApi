package com.Tred.marsApi.controllers;

import com.Tred.marsApi.models.MartianCity;
import com.Tred.marsApi.models.Martian;
import com.Tred.marsApi.repository.MartianCityRepository;
import com.Tred.marsApi.repository.MartianRepository;
import com.Tred.marsApi.services.MartianCityService;
import com.Tred.marsApi.services.MartianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/mars")
public class MarsController {

    @Autowired
    MartianService martianService;

    @Autowired
    MartianCityService martianCityService;

    @GetMapping("/martians")
    public ResponseEntity<?> getAllMartians(){
        try{
            if(martianService.findAll() == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Failed to get Martians\"}");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianService.findAll());
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}");
        }
    }
    @GetMapping("/martians/{id}")
    public ResponseEntity<?> getMartianById(@PathVariable Long id){
        try{
            if(martianService.findById(id) == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianService.findById(id));
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PostMapping("/martians")
    public ResponseEntity<?> saveMartian(@RequestBody Martian martian){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(martianService.save(martian));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PutMapping("/martians/{id}")
    public ResponseEntity<?> updateMartian(@PathVariable Long id, @RequestBody Martian martian){
        try{
            if(martianService.update(id,martian) == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianService.update(id,martian));
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @DeleteMapping("/martians/{id}")
    public ResponseEntity<?> deleteMartian(@PathVariable Long id){
        try{
            if(martianService.delete(id) == false){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianService.delete(id));
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }

    }
    @GetMapping("/bases")
    public ResponseEntity<?> getAllMartiansCities(){
        try{
            if(martianCityService.findAll() == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Failed to get Martians cities\"}");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianService.findAll());
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}");
        }
    }

    @GetMapping("/bases/{id}")
    public ResponseEntity<?> getMartianCityById(@PathVariable Long id){
        try{
            if(martianCityService.findById(id) == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian city not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianCityService.findById(id));
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PostMapping("/bases")
    public ResponseEntity<?> saveMartianCity(@RequestBody MartianCity martianCity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(martianCityService.save(martianCity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PutMapping("/bases/{id}")
    public ResponseEntity<?> updateMartianCity(@PathVariable Long id, @RequestBody MartianCity martianCity){
        try{
            if(martianCityService.update(id,martianCity) == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian city not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianCityService.update(id,martianCity));
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @DeleteMapping("/bases/{id}")
    public ResponseEntity<?> deleteMartianCity(@PathVariable Long id){
        try{
            if(martianCityService.delete(id) == false){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian city not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianCityService.delete(id));
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }

    }
}
