package com.Tred.marsApi.controllers;

import com.Tred.marsApi.models.Base;
import com.Tred.marsApi.models.Martian;
import com.Tred.marsApi.repository.BaseRepository;
import com.Tred.marsApi.repository.MartianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mars")
public class MarsController {

    @Autowired
    MartianRepository martianRepository;
    @Autowired
    BaseRepository baseRepository;

    @GetMapping("/martians")
    public ResponseEntity<List<Martian>> getAllMartians(@RequestParam(required = false) String faction) {
        try {
            List<Martian> martians = new ArrayList<Martian>();

            if (faction == null)
                martianRepository.findAll().forEach(martians::add);
            else
                martianRepository.findByFaction(faction).forEach(martians::add);

            if (martians.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(martians, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/martians/{id}")
    public ResponseEntity<Martian> getMartianById(@PathVariable long id) {
        Optional<Martian> martianData = martianRepository.findById(id);

        if (martianData.isPresent()) {
            return new ResponseEntity<>(martianData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/martians")
    public ResponseEntity<Martian> createMartian(@RequestBody Martian martian) {
        try {
            Martian _martian = martianRepository
                    .save(new Martian(martian.getFirstName(),
                            martian.getLastName(), martian.getAge(),
                            martian.getFaction(), martian.getLegalId(),
                            martian.getBaseId() ));
            return new ResponseEntity<>(_martian, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/martians/{id}")
    public ResponseEntity<Martian> updateMartian(@PathVariable long id, @RequestBody Martian martian) {
        Optional<Martian> martianData = martianRepository.findById(id);

        if (martianData.isPresent()) {
            Martian _martian = martianData.get();
            _martian.setFirstName(martian.getFirstName());
            _martian.setLastName(martian.getLastName());
            _martian.setAge(martian.getAge());
            _martian.setFaction(martian.getFaction());
            _martian.setLegalId(martian.getLegalId());
            _martian.setBaseId(martian.getBaseId());
            return new ResponseEntity<>(martianRepository.save(_martian), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/martians/{id}")
    public ResponseEntity<HttpStatus> deleteMartians(@PathVariable long id) {
        try {
            martianRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bases")
    public ResponseEntity<List<Base>> getAllBases() {
        try {
            List<Base> bases = new ArrayList<Base>();

            baseRepository.findAll().forEach(bases::add);

            if (bases.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(bases, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bases/{id}")
    public ResponseEntity<Base> getBaseById(@PathVariable long id){
        try{
            Optional<Base> baseData = baseRepository.findById(id);

            if(baseData.isPresent()){
                return new ResponseEntity<>(baseData.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/bases")
    public ResponseEntity<Base> createBase(@RequestBody Base base) {
        try {
            Base _base = (Base) baseRepository.save(new Base(base.getBaseName(), base.getCoordinates()));
            return new ResponseEntity<>(_base, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/bases/{id}")
    public ResponseEntity<Base> updateBase(@PathVariable long id, @RequestBody Base base) {
        Optional<Base> baseData = baseRepository.findById(id);

        if (baseData.isPresent()) {
            Base _base = baseData.get();
            _base.setBaseName(base.getBaseName());
            _base.setCoordinates(base.getCoordinates());

            return new ResponseEntity<>(baseRepository.save(_base), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/bases/{id}")
    public ResponseEntity<HttpStatus> deleteBase(@PathVariable long id) {
        try {
            baseRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
