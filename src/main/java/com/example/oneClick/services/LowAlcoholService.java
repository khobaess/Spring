package com.example.oneClick.services;

import com.example.oneClick.models.LowAlcohol;
import com.example.oneClick.repositories.LowAlcoholRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LowAlcoholService {

    private final LowAlcoholRepository lowAlcoholRepository;

    @Autowired
    public LowAlcoholService(LowAlcoholRepository productRepository) {
        this.lowAlcoholRepository = productRepository;
    }

    public List<LowAlcohol> getLowAlcohols(){
        return lowAlcoholRepository.findAll();

    }

    public LowAlcohol getLowAlcohol(int id) {
        Optional<LowAlcohol> lowAlcohol = lowAlcoholRepository.findById(id);
        return lowAlcohol.orElse(null);
    }

    @Transactional
    public void save(LowAlcohol lowAlcohol) {
        lowAlcoholRepository.save(lowAlcohol);
    }

    @Transactional
    public void update(int id, LowAlcohol lowAlcohol){
        lowAlcohol.setId(id);
        lowAlcoholRepository.save(lowAlcohol);
    }

    @Transactional
    public void delete(int id){
        lowAlcoholRepository.deleteById(id);

    }
}
