package com.globalmatics.bike.service;

import com.globalmatics.bike.models.Bike;
import com.globalmatics.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> fetchAll() {
        return bikeRepository.findAll();
    }

    public Bike persist(Bike thisBike) {

        Bike bike = bikeRepository.save(thisBike);

        return bike;

    }

    public Bike fetch(Long id) {
        return bikeRepository.findById(id).get();
    }

    public void delete(String name) {
        bikeRepository.deleteByName(name);
    }


    public Bike update(Long id, Bike thisBike) {


        return bikeRepository.save(thisBike);
    }
}
