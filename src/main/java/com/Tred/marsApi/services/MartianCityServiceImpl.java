package com.Tred.marsApi.services;

import com.Tred.marsApi.models.MartianCity;
import com.Tred.marsApi.repository.BaseRepository;
import com.Tred.marsApi.repository.MartianCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MartianCityServiceImpl extends BaseServiceImpl<MartianCity, Long>{

    @Autowired
    private MartianCityRepository martianCityRepository;

    public MartianCityServiceImpl(BaseRepository<MartianCity, Long> baseRepository){
        super(baseRepository);
    }
}
