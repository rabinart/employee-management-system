package com.rabinart.ems.mapper;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.EmployeeReadDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.entity.Employee;
import com.rabinart.ems.database.entity.PersonalInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeReadDto toDto(Employee entity);

    Employee toEntity(EmployeeCreateEditDto dto);

    PersonalInfoCreateEditDto toDto(PersonalInfo entity);

    PersonalInfo toEntity(PersonalInfoCreateEditDto dto);
}
