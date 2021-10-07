package com.williammacedo.uber_clone;

import com.williammacedo.uber_clone.domain.Driver;
import com.williammacedo.uber_clone.domain.Passenger;
import com.williammacedo.uber_clone.repository.DriverRepository;
import com.williammacedo.uber_clone.repository.PassengerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class UberCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberCloneApplication.class, args);
    }

    @Bean
    public ApplicationRunner initializerDriver(DriverRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    Driver.builder().name("Alexandre").birthDate(LocalDate.of(1985, 3, 17)).build(),
                    Driver.builder().name("Mclovi").birthDate(LocalDate.of(1988, 10, 16)).build(),
                    Driver.builder().name("Thomas").birthDate(LocalDate.of(1983, 6, 11)).build(),
                    Driver.builder().name("Vernie").birthDate(LocalDate.of(1981, 10, 2)).build(),
                    Driver.builder().name("Jeanne").birthDate(LocalDate.of(1989, 2, 9)).build(),
                    Driver.builder().name("Mozelle").birthDate(LocalDate.of(1987, 8, 27)).build(),
                    Driver.builder().name("Dolores").birthDate(LocalDate.of(1990, 9, 30)).build(),
                    Driver.builder().name("Fernando").birthDate(LocalDate.of(1994, 1, 1)).build()
                ));
            }
        };
    }

    @Bean
    public ApplicationRunner initializerPassenger(PassengerRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    Passenger.builder().name("Gilbert").build(),
                    Passenger.builder().name("Orval").build(),
                    Passenger.builder().name("Rosemary").build(),
                    Passenger.builder().name("Estefania").build(),
                    Passenger.builder().name("Fabrícia").build(),
                    Passenger.builder().name("Rafael").build(),
                    Passenger.builder().name("Marcelo").build(),
                    Passenger.builder().name("Isabella").build()
                ));
            }
        };
    }

}
