package com.williammacedo.uber_clone.mapper;

import com.williammacedo.uber_clone.domain.Driver;
import com.williammacedo.uber_clone.dto.DriverInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DriverMapper {

    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    Driver toEntity(DriverInputDTO dto);

    @Mapping(target = "id", ignore = true)
    Driver update(@MappingTarget Driver driver, DriverInputDTO dto);
}
