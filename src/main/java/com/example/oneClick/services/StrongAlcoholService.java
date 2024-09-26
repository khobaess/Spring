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
    public void update(int id, StrongAlcohol strongAlcohol) {
        Optional<StrongAlcohol> optionalStrongAlcohol = strongAlcoholRepository.findById(id);
        if (optionalStrongAlcohol.isPresent()) {
            StrongAlcohol existingStrongAlcohol = optionalStrongAlcohol.get();

            if (strongAlcohol.getName() != null) {
                existingStrongAlcohol.setName(strongAlcohol.getName());
            }
            if (strongAlcohol.getDescription() != null) {
                existingStrongAlcohol.setDescription(strongAlcohol.getDescription());
            }
            if (strongAlcohol.getPhoto() != null) {
                existingStrongAlcohol.setPhoto(strongAlcohol.getPhoto());
            }
            if (strongAlcohol.getPrice() > 0) {
                existingStrongAlcohol.setPrice(strongAlcohol.getPrice());
            }

            strongAlcoholRepository.save(existingStrongAlcohol);
        }
    }

    @Transactional
    public void delete(int id){
        strongAlcoholRepository.deleteById(id);

    }
}
