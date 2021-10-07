package com.williammacedo.uber_clone.service;

import com.williammacedo.uber_clone.controller.PassengerController;
import com.williammacedo.uber_clone.domain.Passenger;
import com.williammacedo.uber_clone.domain.TravelRequest;
import com.williammacedo.uber_clone.domain.enums.TravelRequestStatus;
import com.williammacedo.uber_clone.dto.TravelRequestInputDTO;
import com.williammacedo.uber_clone.dto.TravelRequestOutputDTO;
import com.williammacedo.uber_clone.mapper.TravelRequestMapper;
import com.williammacedo.uber_clone.repository.TravelRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TravelRequestService {

    private static final TravelRequestMapper mapper = TravelRequestMapper.INSTANCE;

    private TravelRequestRepository repository;
    private PassengerService passengerService;

    public EntityModel<TravelRequestOutputDTO> create(TravelRequestInputDTO dto) {
        TravelRequest entity = mapper.toEntity(dto);
        entity.setPassenger(passengerService.findById(dto.getPassengerId()));
        entity.setStatus(TravelRequestStatus.CREATED);
        entity.setCreationDate(LocalDateTime.now());

        TravelRequest entitySaved = repository.save(entity);
        TravelRequestOutputDTO outputDTO = mapper.toDTO(entitySaved);
        return buildOutputModel(entitySaved, outputDTO);
    }

    public EntityModel<TravelRequestOutputDTO> buildOutputModel (TravelRequest entity, TravelRequestOutputDTO output) {
        EntityModel<TravelRequestOutputDTO> model = EntityModel.of(output);

        Link passengerLink = WebMvcLinkBuilder
                .linkTo(PassengerController.class)
                .slash(entity.getPassenger().getId())
                .withRel("passenger")
                .withTitle(entity.getPassenger().getName());
        model.add(passengerLink);
        return model;
    }
}
