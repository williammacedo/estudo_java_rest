package com.williammacedo.uber_clone.repository;

import com.williammacedo.uber_clone.domain.TravelRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
}
