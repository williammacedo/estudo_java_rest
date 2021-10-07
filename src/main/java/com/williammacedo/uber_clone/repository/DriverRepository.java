package com.williammacedo.uber_clone.repository;

import com.williammacedo.uber_clone.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
