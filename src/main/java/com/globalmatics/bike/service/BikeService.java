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

    public void persist(Bike bike) {

        bikeRepository.save(bike);

    }

    public Bike fetch(Long id) {
        return bikeRepository.findById(id).get();
    }

}
