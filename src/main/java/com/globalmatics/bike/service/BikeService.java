package com.globalmatics.bike.service;

import com.globalmatics.bike.models.Bike;
import com.globalmatics.bike.repository.BikeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> fetchAll() {
        return bikeRepository.findAll();
    }

    public Bike persist(Bike thisBike) {

        Bike bike = bikeRepository.save(thisBike);

//        return bikeRepository.findById(id).orElse(new Bike());

        return bike;

    }

    public Bike fetch(Long id) {
        return bikeRepository.findById(id).get();
    }

    public void delete(String name) {

        List<Bike> bikesToDelete = bikeRepository.findAllByName(name);

        bikesToDelete.forEach(bike ->
            bikeRepository.delete(bike)
        );


        log.info("bike(s) to be deleted" + bikesToDelete);

//        or
//        bikesToDelete.forEach(bikeRepository::delete);

    }



    public Bike update(String name, Bike updatedBike) {

        Bike existingBike = bikeRepository.findByName(name);


        updatedBike.setId(existingBike.getId());

//        BeanUtils.copyProperties(name, existingBike);

        return bikeRepository.save(updatedBike);
    }
}
