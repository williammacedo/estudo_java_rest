package com.williammacedo.uber_clone.controller;

import com.williammacedo.uber_clone.domain.TravelRequest;
import com.williammacedo.uber_clone.dto.TravelRequestInputDTO;
import com.williammacedo.uber_clone.dto.TravelRequestOutputDTO;
import com.williammacedo.uber_clone.service.TravelRequestService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travelRequests")
@AllArgsConstructor
public class TravelRequestController {

    private TravelRequestService service;

    @PostMapping
    public EntityModel<TravelRequestOutputDTO> makeTravelRequest (@RequestBody TravelRequestInputDTO dto) {
        return service.create(dto);
    }
}
