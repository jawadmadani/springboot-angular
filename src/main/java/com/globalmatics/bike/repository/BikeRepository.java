package com.globalmatics.bike.repository;

import com.globalmatics.bike.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
