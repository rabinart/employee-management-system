package com.rabinart.ems.integration.service;

import com.rabinart.ems.database.repository.EmployeeRepository;
import com.rabinart.ems.integration.IntegrationTestBase;
import com.rabinart.ems.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
public class EmployeeServiceIT extends IntegrationTestBase {

    private final EmployeeRepository employeeRepository;

    @Test
    void findById(){
        employeeRepository.findById(2);
    }

}
