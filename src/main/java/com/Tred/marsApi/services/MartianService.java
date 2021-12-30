package com.Tred.marsApi.services;

import com.Tred.marsApi.models.Martian;
import com.Tred.marsApi.repository.MartianCityRepository;
import com.Tred.marsApi.repository.MartianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class MartianService implements BaseService<Martian>{

    @Autowired
    MartianRepository martianRepository;

    @Override
    @Transactional
    public List<Martian> findAll() throws Exception {
        try{
            List<Martian> entities = martianRepository.findAll();
            if(entities.isEmpty()){
                return null;
            }
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Martian findById(Long id) throws Exception {
        Optional<Martian> martianData = martianRepository.findById(id);
        try{
            if (martianData.isPresent()) {
                return martianData.get();
            } else {
                return null;
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Martian save(Martian entity) throws Exception {
        try{
            return martianRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Martian update(Long id, Martian entity) throws Exception {
        try{
            Optional<Martian> martianOptional = martianRepository.findById(id);

            if (martianOptional.isPresent()) {
                Martian _martian = martianOptional.get();
                _martian.setFirstName(entity.getFirstName());
                _martian.setLastName(entity.getLastName());
                _martian.setAge(entity.getAge());
                _martian.setFaction(entity.getFaction());
                _martian.setLegalId(entity.getLegalId());
                _martian.setBaseId(entity.getBaseId());
                return _martian;
            } else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(martianRepository.existsById(id)){
                martianRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
