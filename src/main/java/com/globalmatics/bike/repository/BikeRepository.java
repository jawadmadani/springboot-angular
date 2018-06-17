package com.globalmatics.bike.repository;

import com.globalmatics.bike.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Query(value = "SELECT * FROM BIKE WHERE NAME = ?1", nativeQuery = true)
    void deleteByName(String name);
//
//    @Query(value = "update bike set name = ?, email = ?, phone = ?, model = ?, where id = 1", nativeQuery = true)
//    void update(Bike name);

}