package com.williammacedo.uber_clone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TravelRequestInputDTO {
    @NotNull
    private Long passengerId;
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
}
