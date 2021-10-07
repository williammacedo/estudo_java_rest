package com.williammacedo.uber_clone.mapper;

import com.williammacedo.uber_clone.domain.Passenger;
import com.williammacedo.uber_clone.dto.PassengerInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PassengerMapper {

    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    Passenger toEntity(PassengerInputDTO dto);

    @Mapping(target = "id", ignore = true)
    Passenger update(@MappingTarget Passenger entity, PassengerInputDTO dto);
}
