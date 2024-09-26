package com.example.oneClick.services;

import com.example.oneClick.models.Champagne;
import com.example.oneClick.repositories.ChampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ChampagneService {

    private final ChampagneRepository champagneRepository;

    @Autowired
    public ChampagneService(ChampagneRepository champagneRepository) {
        this.champagneRepository = champagneRepository;
    }

    public List<Champagne> getChampagnes(){
        return champagneRepository.findAll();

    }

    public Champagne getChampagne(int id) {
        Optional<Champagne> product = champagneRepository.findById(id);
        return product.orElse(null);
    }

    @Transactional
    public void save(Champagne champagne) {
        champagneRepository.save(champagne);
    }

    @Transactional
    public void update(int id, Champagne champagne) {
        Optional<Champagne> optionalChampagne = champagneRepository.findById(id);
        if (optionalChampagne.isPresent()) {
            Champagne existingChampagne = optionalChampagne.get();

            if (champagne.getName() != null) {
                existingChampagne.setName(champagne.getName());
            }
            if (champagne.getDescription() != null) {
                existingChampagne.setDescription(champagne.getDescription());
            }
            if (champagne.getPhoto() != null) {
                existingChampagne.setPhoto(champagne.getPhoto());
            }
            if (champagne.getPrice() > 0) {
                existingChampagne.setPrice(champagne.getPrice());
            }

            champagneRepository.save(existingChampagne);
        }
    }
    
    @Transactional
    public void delete(int id){
        champagneRepository.deleteById(id);
    }


}
