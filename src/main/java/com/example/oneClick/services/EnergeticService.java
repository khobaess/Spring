package com.example.oneClick.services;

import com.example.oneClick.models.Energetic;
import com.example.oneClick.repositories.EnergeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EnergeticService {

    private final EnergeticRepository energeticRepository;

    @Autowired
    public EnergeticService(EnergeticRepository productRepository) {
        this.energeticRepository = productRepository;
    }

    public List<Energetic> getEnergetics(){
       return energeticRepository.findAll();

    }

    public Energetic getEnergetic(int id) {
        Optional<Energetic> product = energeticRepository.findById(id);
        return product.orElse(null);
    }

    @Transactional
    public void save(Energetic energetic) {
        energeticRepository.save(energetic);
    }

    @Transactional
    public void update(int id, Energetic energetic){
        energetic.setId(id);
        energeticRepository.save(energetic);
    }

    @Transactional
    public void delete(int id){
        energeticRepository.deleteById(id);

    }
}