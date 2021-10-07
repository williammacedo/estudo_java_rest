package com.williammacedo.uber_clone.mapper;

import com.williammacedo.uber_clone.domain.TravelRequest;
import com.williammacedo.uber_clone.dto.TravelRequestInputDTO;
import com.williammacedo.uber_clone.dto.TravelRequestOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TravelRequestMapper {

    TravelRequestMapper INSTANCE = Mappers.getMapper(TravelRequestMapper.class);

    @Mapping(source = "passengerId", target = "passenger.id")
    TravelRequest toEntity(TravelRequestInputDTO dto);

    TravelRequestOutputDTO toDTO(TravelRequest entity);

    @Mapping(source = "passengerId", target = "passenger.id")
    TravelRequest update(@MappingTarget TravelRequest entity, TravelRequestInputDTO dto);
}
