package com.Tred.marsApi.repository;

import com.Tred.marsApi.models.MartianCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MartianCityRepository extends BaseRepository<MartianCity, Long>  {

}
