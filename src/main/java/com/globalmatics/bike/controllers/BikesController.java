package com.globalmatics.bike.controllers;

import com.globalmatics.bike.models.Bike;
import com.globalmatics.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeRepository bikeRepository;



    // API endpoints for getting the full list.
    @GetMapping("/all")
    public List<Bike> bikeList() {
        List<Bike> bikes = new ArrayList<>();
        return bikes;
    }

    // OR //

    @GetMapping("/all2")
    public List<Bike> bikeList2() {
        return bikeRepository.findAll();
    }




    // API for adding a bike.
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike thisBike) {

        bikeRepository.save(thisBike);
    }





    // API for getting a certain bike.
    @GetMapping("/{id}")
    public Bike getCertain(@PathVariable("id") long id) {

        return bikeRepository.getOne(id);
    }
}
