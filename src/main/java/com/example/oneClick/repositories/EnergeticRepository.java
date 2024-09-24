package com.example.oneClick.repositories;

import com.example.oneClick.models.Energetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnergeticRepository extends JpaRepository <Energetic, Integer>{
    Optional<Energetic> findById(int id);
}
