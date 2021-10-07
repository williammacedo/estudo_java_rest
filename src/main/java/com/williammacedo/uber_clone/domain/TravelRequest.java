package com.williammacedo.uber_clone.domain;

import com.williammacedo.uber_clone.domain.enums.TravelRequestStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class TravelRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Passenger passenger;
    String origin;
    String destination;

    @Enumerated(EnumType.STRING)
    TravelRequestStatus status;
    LocalDateTime creationDate;
}
