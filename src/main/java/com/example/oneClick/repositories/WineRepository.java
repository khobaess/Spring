package com.example.oneClick.repositories;

import com.example.oneClick.models.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {
}
