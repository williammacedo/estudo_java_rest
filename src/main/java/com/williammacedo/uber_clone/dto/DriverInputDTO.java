package com.williammacedo.uber_clone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DriverInputDTO {
    @NotBlank
    private String name;
    @NotNull
    private LocalDate birthDate;
}
