package com.example.oneClick.repositories;

import com.example.oneClick.models.LowAlcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LowAlcoholRepository extends JpaRepository<LowAlcohol, Integer> {
}
