package com.williammacedo.uber_clone.service;

import com.williammacedo.uber_clone.domain.Driver;
import com.williammacedo.uber_clone.dto.DriverInputDTO;
import com.williammacedo.uber_clone.mapper.DriverMapper;
import com.williammacedo.uber_clone.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class DriverService {

    private DriverRepository repository;
    private static final DriverMapper mapper = DriverMapper.INSTANCE;

    public List<Driver> findAll() {
        return repository.findAll();
    }

    public Driver findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Driver create(DriverInputDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    public Driver update(Long id, DriverInputDTO dto) {
        Driver foundDriver = findById(id);
        mapper.update(foundDriver, dto);
        return repository.save(foundDriver);
    }

    @Transactional
    public Driver patch(Long id, DriverInputDTO dto) {
        Driver foundDriver = findById(id);
        mapper.update(foundDriver, dto);
        return repository.save(foundDriver);
    }

    @Transactional
    public void delete(Long id) {
        Driver foundDriver = findById(id);
        repository.delete(foundDriver);
    }
}
