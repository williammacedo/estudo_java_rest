package com.williammacedo.uber_clone.repository;

import com.williammacedo.uber_clone.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
