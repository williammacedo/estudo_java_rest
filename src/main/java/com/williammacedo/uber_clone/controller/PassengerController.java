package com.williammacedo.uber_clone.controller;

import com.williammacedo.uber_clone.domain.Passenger;
import com.williammacedo.uber_clone.dto.PassengerInputDTO;
import com.williammacedo.uber_clone.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/passengers")
@AllArgsConstructor
public class PassengerController {

    private PassengerService service;

    @GetMapping
    public List<Passenger> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Passenger create(@RequestBody @Valid PassengerInputDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id, @RequestBody @Valid PassengerInputDTO dto) {
        return service.update(id, dto);
    }

    @PatchMapping("/{id}")
    public Passenger patch(@PathVariable Long id, @RequestBody PassengerInputDTO dto) {
        return service.patch(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
