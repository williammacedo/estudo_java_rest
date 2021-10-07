package com.williammacedo.uber_clone.controller;

import com.williammacedo.uber_clone.domain.Driver;
import com.williammacedo.uber_clone.dto.DriverInputDTO;
import com.williammacedo.uber_clone.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/drivers")
@AllArgsConstructor
public class DriverController {

    private DriverService service;

    @GetMapping
    public List<Driver> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Driver findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Driver create(@RequestBody @Valid DriverInputDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Driver update(@PathVariable Long id, @RequestBody @Valid DriverInputDTO dto) {
        return service.update(id, dto);
    }

    @PatchMapping("/{id}")
    public Driver patch(@PathVariable Long id, @RequestBody DriverInputDTO dto) {
        return service.patch(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
