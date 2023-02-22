package com.rabinart.ems.mapper;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.EmployeeReadDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.dto.PersonalInfoReadDto;
import com.rabinart.ems.database.entity.Employee;
import com.rabinart.ems.database.entity.PersonalInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeReadDto toDto(Employee entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "personalInfo", ignore = true)
    @Mapping(target = "busyness", ignore = true)
    Employee toEntity(EmployeeCreateEditDto dto);

    PersonalInfoReadDto toDto(PersonalInfo entity);
//
//    @Mapping(target = "id", ignore = true)
//    PersonalInfo toEntity(PersonalInfoCreateEditDto dto);

    Employee update(@MappingTarget Employee employee, EmployeeCreateEditDto dto);
}
