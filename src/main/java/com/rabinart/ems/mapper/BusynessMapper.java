package com.rabinart.ems.mapper;

import com.rabinart.ems.database.dto.BusynessDto;
import com.rabinart.ems.database.dto.BusynessReadDto;
import com.rabinart.ems.database.entity.Busyness;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusynessMapper {

    @Mapping(target = "employeeName", source = "employee.name")
    @Mapping(target = "officeName", source = "office.name")
    BusynessReadDto toReadDto(Busyness entity);

    @Mapping(target = "employeeName", source = "employee.name")
    @Mapping(target = "officeName", source = "office.name")
    BusynessDto toDto(Busyness entity);
}
