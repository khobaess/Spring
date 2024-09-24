package com.example.oneClick.repositories;

import com.example.oneClick.models.Champagne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampagneRepository extends JpaRepository<Champagne, Integer> {
}
