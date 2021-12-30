package com.Tred.marsApi.services;

import com.Tred.marsApi.models.Martian;
import com.Tred.marsApi.models.MartianCity;
import com.Tred.marsApi.repository.MartianCityRepository;
import com.Tred.marsApi.repository.MartianRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class MartianCityService implements BaseService<MartianCity>{

    @Autowired
    MartianCityRepository martianCityRepository;

    @Override
    @Transactional
    public List<MartianCity> findAll() throws Exception {
        try{
            List<MartianCity> martianCities = martianCityRepository.findAll();
            if (martianCities.isEmpty()) {
                return null;
            }else{
                return martianCities;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public MartianCity findById(Long id) throws Exception {
        try{
            Optional<MartianCity> martianCityData = martianCityRepository.findById(id);
            if(martianCityData.isPresent()){
                return martianCityData.get();
            }else{
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public MartianCity save(MartianCity entity) throws Exception {
        try{
            return martianCityRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public MartianCity update(Long id, MartianCity entity) throws Exception {
        try{
            Optional<MartianCity> cityOptional = martianCityRepository.findById(id);
            if(cityOptional.isPresent()){
                MartianCity _martianCity = cityOptional.get();
                _martianCity.setBaseName(entity.getBaseName());
                _martianCity.setCoordinates(entity.getCoordinates());
                return _martianCity;
            }else{
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(martianCityRepository.existsById(id)){
                martianCityRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
