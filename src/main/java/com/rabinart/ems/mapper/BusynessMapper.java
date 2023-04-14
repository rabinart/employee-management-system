package com.rabinart.ems.mapper;

import com.rabinart.ems.database.dto.BusynessCreateDto;
import com.rabinart.ems.database.dto.BusynessDto;
import com.rabinart.ems.database.dto.BusynessReadDto;
import com.rabinart.ems.database.entity.Busyness;
import com.rabinart.ems.database.repository.EmployeeRepository;
import com.rabinart.ems.database.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class BusynessMapper {

    private OfficeRepository officeRepository;
    private EmployeeRepository employeeRepository;

    @Mapping(target = "employeeName", source = "employee.name")
    @Mapping(target = "officeName", source = "office.name")
    public abstract BusynessReadDto toReadDto(Busyness entity);

    @Mapping(target = "employeeName", source = "employee.name")
    @Mapping(target = "officeName", source = "office.name")
    public abstract BusynessDto toDto(Busyness entity);

    public Busyness toEntity(BusynessCreateDto dto) {
        var busyness = new Busyness();
        busyness.setEmployee(employeeRepository.getReferenceById(dto.getEmployeeId()));
        busyness.setOffice(officeRepository.getReferenceById(dto.getOfficeId()));
        busyness.setJobType(dto.getJobType());
        busyness.setEarned(dto.getEarned());
        busyness.setBusyFrom(dto.getBusyFrom());
        busyness.setBusyTill(dto.getBusyTill());
        return busyness;
    }
}
