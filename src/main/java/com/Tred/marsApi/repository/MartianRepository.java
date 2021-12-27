package com.Tred.marsApi.repository;

import com.Tred.marsApi.models.Martian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MartianRepository extends JpaRepository<Martian, Long> {
    List<Martian> findByBaseId(int baseId);
    List<Martian> findByFaction(String faction);
}

