package com.Tred.marsApi.repository;

import com.Tred.marsApi.models.Martian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MartianRepository extends JpaRepository<Martian, Long> {

}

