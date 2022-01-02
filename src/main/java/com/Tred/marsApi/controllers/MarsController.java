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
            List<Martian> martians = martianService.findAll();
            if(martians == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Failed to get Martians\"}");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martians);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}");
        }
    }
    @GetMapping("/martians/{id}")
    public ResponseEntity<?> getMartianById(@PathVariable Long id){
        try{
            Martian martian = martianService.findById(id);
            if(martian == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martian);
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
            Martian updatedMartian = martianService.update(id,martian);
            if(updatedMartian == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(updatedMartian);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @DeleteMapping("/martians/{id}")
    public ResponseEntity<?> deleteMartian(@PathVariable Long id){
        try{
            boolean deleted = martianService.delete(id);
            if( deleted == false){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }

    }
    @GetMapping("/martiancities")
    public ResponseEntity<?> getAllMartianCities(){
        try{
            List<MartianCity> martianCities = martianCityService.findAll();
            if(martianCities == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Failed to get Martian cities\"}");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianCities);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}");
        }
    }

    @GetMapping("/martiancities/{id}")
    public ResponseEntity<?> getMartianCityById(@PathVariable Long id){
        try{
            MartianCity martianCity = martianCityService.findById(id);
            if( martianCity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian city not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(martianCity);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PostMapping("/martiancities")
    public ResponseEntity<?> saveMartianCity(@RequestBody MartianCity martianCity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(martianCityService.save(martianCity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PutMapping("/martiancities/{id}")
    public ResponseEntity<?> updateMartianCity(@PathVariable Long id, @RequestBody MartianCity martianCity){
        try{
            MartianCity updatedCity = martianCityService.update(id,martianCity);
            if( updatedCity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian city not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(updatedCity);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @DeleteMapping("/martiancities/{id}")
    public ResponseEntity<?> deleteMartianCity(@PathVariable Long id){
        try{
            boolean deleted = martianCityService.delete(id);
            if(deleted == false){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian city not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }

    }
}
