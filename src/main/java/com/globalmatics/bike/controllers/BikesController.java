package com.globalmatics.bike.controllers;

import com.globalmatics.bike.models.Bike;
import com.globalmatics.bike.repository.BikeRepository;
import com.globalmatics.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeService bikeService;



    // API endpoints for getting the full list.
    @GetMapping("/all")
    public ResponseEntity<List<Bike>> bikeList2() {
        List<Bike> listOfBikes = bikeService.fetchAll();

        HttpStatus httpStatus = HttpStatus.OK;

        if (listOfBikes.size() == 0) {
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(listOfBikes, httpStatus);
    }




    // API for adding a bike.
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Bike thisBike) {

        bikeService.persist(thisBike);
    }





    // API for getting a certain bike.
    @GetMapping("/{id}")
    public Bike getCertain(@PathVariable("id") long id) {

        return bikeService.fetch(id);
    }
}
