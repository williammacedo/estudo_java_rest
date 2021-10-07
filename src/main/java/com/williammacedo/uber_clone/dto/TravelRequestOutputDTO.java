package com.williammacedo.uber_clone.dto;

import com.williammacedo.uber_clone.domain.enums.TravelRequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TravelRequestOutputDTO {
    private Long id;
    private String origin;
    private String destination;
    private TravelRequestStatus status;
    private LocalDateTime creationDate;
}
