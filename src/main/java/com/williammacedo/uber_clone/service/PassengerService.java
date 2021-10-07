package com.williammacedo.uber_clone.service;

import com.williammacedo.uber_clone.domain.Passenger;
import com.williammacedo.uber_clone.dto.PassengerInputDTO;
import com.williammacedo.uber_clone.mapper.PassengerMapper;
import com.williammacedo.uber_clone.repository.PassengerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PassengerService {

    private PassengerRepository repository;
    private static final PassengerMapper mapper = PassengerMapper.INSTANCE;

    public List<Passenger> findAll() {
        return repository.findAll();
    }

    public Passenger findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Passenger id %s not found.", id)));
    }

    @Transactional
    public Passenger create(PassengerInputDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Transactional
    public Passenger update(Long id, PassengerInputDTO dto) {
        Passenger foundPassenger = findById(id);
        mapper.update(foundPassenger, dto);
        return repository.save(foundPassenger);
    }

    @Transactional
    public Passenger patch(Long id, PassengerInputDTO dto) {
        Passenger foundPassenger = findById(id);
        mapper.update(foundPassenger, dto);
        return repository.save(foundPassenger);
    }

    @Transactional
    public void delete(Long id) {
        Passenger foundPassenger = findById(id);
        repository.delete(foundPassenger);
    }
}
