package com.rabinart.ems.mapper;

import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.entity.EmployeeStatus;
import com.rabinart.ems.database.entity.PersonalInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface InfoMapper {

    PersonalInfoCreateEditDto toDto(PersonalInfo entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", defaultValue = "ACTIVE")
    @Mapping(target = "description", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    PersonalInfo toEntity(PersonalInfoCreateEditDto dto);
}
