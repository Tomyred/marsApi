package com.Tred.marsApi.controllers;

import com.Tred.marsApi.models.Base;
import com.Tred.marsApi.models.Martian;
import com.Tred.marsApi.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    @Autowired
    protected S service;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            List<E> data = service.findAll();
            if(data == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No data found\"}");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(data);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            E entity = service.findById(id);
            if(entity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(entity);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try{
            E updatedEntity = service.update(id,entity);
            if(updatedEntity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Element not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(updatedEntity);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            boolean deleted = service.delete(id);
            if( deleted == false){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Martian not found\"}" );
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"INTERNAL_SERVER_ERROR\"}" );
        }

    }
}
