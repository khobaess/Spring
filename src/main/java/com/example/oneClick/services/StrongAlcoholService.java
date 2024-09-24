package com.example.oneClick.services;

import com.example.oneClick.models.StrongAlcohol;
import com.example.oneClick.repositories.StrongAlcoholRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StrongAlcoholService {

    private final StrongAlcoholRepository strongAlcoholRepository;

    @Autowired
    public StrongAlcoholService(StrongAlcoholRepository strongAlcoholRepository) {
        this.strongAlcoholRepository = strongAlcoholRepository;
    }

    public List<StrongAlcohol> getStrongAlcohols(){
        return strongAlcoholRepository.findAll();

    }

    public StrongAlcohol getStrongAlcohol(int id) {
        Optional<StrongAlcohol> strongAlcohol = strongAlcoholRepository.findById(id);
        return strongAlcohol.orElse(null);
    }

    @Transactional
    public void save(StrongAlcohol strongAlcohol) {
        strongAlcoholRepository.save(strongAlcohol);
    }

    @Transactional
    public void update(int id, StrongAlcohol strongAlcohol){
        strongAlcohol.setId(id);
        strongAlcoholRepository.save(strongAlcohol);
    }

    @Transactional
    public void delete(int id){
        strongAlcoholRepository.deleteById(id);

    }
}
