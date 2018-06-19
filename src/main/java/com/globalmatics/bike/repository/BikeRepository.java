package com.globalmatics.bike.repository;

import com.globalmatics.bike.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Query(value = "SELECT * FROM BIKE WHERE NAME = ?1", nativeQuery = true)
    Bike findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM BIKE WHERE NAME = ?1", nativeQuery = true)
    List<Bike> findAllByName(@Param("name") String name);


}