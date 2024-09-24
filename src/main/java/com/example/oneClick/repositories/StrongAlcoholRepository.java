package com.example.oneClick.repositories;

import com.example.oneClick.models.StrongAlcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrongAlcoholRepository extends JpaRepository<StrongAlcohol, Integer> {
}
