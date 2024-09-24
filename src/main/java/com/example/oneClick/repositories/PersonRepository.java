package com.example.oneClick.repositories;

import com.example.oneClick.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {
     Optional<Person> findByUsername(String username);

}
