package com.rabinart.ems.integration.service;

import com.rabinart.ems.database.repository.EmployeeRepository;
import com.rabinart.ems.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
public class EmployeeServiceIT {

    private final EmployeeRepository employeeRepository;

    @Test
    void findById(){
        employeeRepository.findById(2);
    }

}
