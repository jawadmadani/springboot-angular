package com.globalmatics.bike.controllers;

import com.globalmatics.bike.exceptions.BikeNotFoundException;
import com.globalmatics.bike.models.Bike;
import com.globalmatics.bike.models.ExceptionJSONInfo;
import com.globalmatics.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;



    // API endpoints for getting the full list.
    @GetMapping("/all")
    public ResponseEntity<List<Bike>> bikeList() {
        List<Bike> listOfBikes = bikeService.fetchAll();

        HttpStatus httpStatus = HttpStatus.OK;

        if (listOfBikes.size() == 0) {
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(listOfBikes, httpStatus);
    }



    // API for getting a certain bike.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bike getCertain(@PathVariable("id") Long id) throws BikeNotFoundException {

        Bike getBike = null;
        try {
            getBike = bikeService.fetch(id);
        } catch (Exception e) {
            throw new BikeNotFoundException("id-" + id);
        }

        return getBike;

    }


    // API for adding a bike.
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike create(@RequestBody Bike thisBike) {

        Bike newBike = bikeService.persist(thisBike);

        return newBike;
    }


//    API for deleting a bike
    @RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("name") String name) {

        bikeService.delete(name);
    }


//    API for updating an entity
    @RequestMapping(path = "/update/{name}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Bike update(@PathVariable("name") String name, @RequestBody Bike thisBike) {

        return bikeService.update(name, thisBike);
    }

//    // returning a custom object to the client
//    @ExceptionHandler(BikeNotFoundException.class)
//    private ResponseEntity<ExceptionJSONInfo> handleBikeNotFoundException(HttpServletRequest request, Exception ex){
//
//        ExceptionJSONInfo response = new ExceptionJSONInfo();
//        response.setPath(request.getRequestURL().toString());
//        response.setMessage(ex.getMessage());
//
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }

}
