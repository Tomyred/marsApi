package com.Tred.marsApi.services;

import com.Tred.marsApi.models.Martian;
import com.Tred.marsApi.repository.BaseRepository;
import com.Tred.marsApi.repository.MartianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MartianServiceImpl extends BaseServiceImpl<Martian, Long>{

    @Autowired
    private MartianRepository martianRepository;

    public MartianServiceImpl(BaseRepository<Martian, Long> baseRepository){
        super(baseRepository);
    }
}
