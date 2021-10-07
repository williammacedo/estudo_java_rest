package com.williammacedo.uber_clone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PassengerInputDTO {
    @NotBlank
    private String name;
}
