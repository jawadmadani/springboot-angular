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

        List<Bike> listOfBikes = bikeRepository.findAll();
        log.info("List of bikes" + listOfBikes);

        return listOfBikes;
    }

    public Bike persist(Bike thisBike) {

        Bike bike = bikeRepository.save(thisBike);

        log.info("Bike just added" + bike);

        return bike;
    }

    public Bike fetch(Long id) {

        Bike fetchedBike = bikeRepository.findById(id).get();
        log.info("Fetched bike" + fetchedBike);

        return fetchedBike;
    }

    public void delete(String name) {

        List<Bike> bikesToDelete = bikeRepository.findAllByName(name);

        bikesToDelete.forEach(bike ->
            bikeRepository.delete(bike));
        log.info("bike(s) to be deleted" + bikesToDelete);

//        or alternatively
//        bikesToDelete.forEach(bikeRepository::delete);

    }



    public Bike update(String name, Bike updatedBike) {

        Bike existingBike = bikeRepository.findByName(name);
        log.info("Bike that will be updated" + existingBike);

        updatedBike.setId(existingBike.getId());
        log.info("Updated bike" + updatedBike);

//        or alternatively
//        BeanUtils.copyProperties(name, existingBike);

        return bikeRepository.save(updatedBike);
    }
}
