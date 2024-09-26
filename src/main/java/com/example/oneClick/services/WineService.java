package com.example.oneClick.services;

import com.example.oneClick.models.Wine;
import com.example.oneClick.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WineService {
    private final WineRepository wineRepository;

    @Autowired
    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<Wine> getWines(){
        return wineRepository.findAll();

    }

    public Wine getWine(int id) {
        Optional<Wine> wine = wineRepository.findById(id);
        return wine.orElse(null);
    }

    @Transactional
    public void save(Wine strongAlcohol) {
        wineRepository.save(strongAlcohol);
    }

    @Transactional
    public void update(int id, Wine wine) {
        Optional<Wine> optionalWine = wineRepository.findById(id);
        if (optionalWine.isPresent()) {
            Wine existingWine = optionalWine.get();


            if (wine.getName() != null) {
                existingWine.setName(wine.getName());
            }
            if (wine.getDescription() != null) {
                existingWine.setDescription(wine.getDescription());
            }
            if (wine.getPhoto() != null) {
                existingWine.setPhoto(wine.getPhoto());
            }
            if (wine.getPrice() > 0) {
                existingWine.setPrice(wine.getPrice());
            }

            wineRepository.save(existingWine);
        }
    }

    @Transactional
    public void delete(int id){
        wineRepository.deleteById(id);
    }
}
