package com.globalmatics.bike.service;

import com.globalmatics.bike.exceptions.BikeNotFoundException;
import com.globalmatics.bike.models.Bike;
import com.globalmatics.bike.repository.BikeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private static final Logger log = LoggerFactory.getLogger(BikeService.class);

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

        Bike fetchedBike = null;

        try {
            fetchedBike = bikeRepository.findById(id).get();

            return fetchedBike;

        } catch (BikeNotFoundException e) {

            log.error("ERROR: Bike not found:- {} ", e.getMessage(), e);
            throw new BikeNotFoundException(e.getMessage(), e);
        }


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
