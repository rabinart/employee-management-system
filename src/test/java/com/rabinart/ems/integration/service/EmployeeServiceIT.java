package com.rabinart.ems.integration.service;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.entity.Employee;
import com.rabinart.ems.database.repository.EmployeeRepository;
import com.rabinart.ems.integration.IntegrationTestBase;
import com.rabinart.ems.integration.annotation.IT;
import com.rabinart.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class EmployeeServiceIT extends IntegrationTestBase {

    private final EmployeeService employeeService;
    @Test
    void findById(){
        var employee = employeeService.findById(2);
        assertTrue(employee.isPresent());
    }

    @Test
    void save(){
        var dto = new EmployeeCreateEditDto(
                "artem", "dwmio@fmwe.ru",
                new PersonalInfoCreateEditDto(18, "loh"));
        employeeService.create(dto);
    }

}
