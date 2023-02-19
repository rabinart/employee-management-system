package com.rabinart.ems.integration.service;

import com.rabinart.ems.database.entity.Employee;
import com.rabinart.ems.database.repository.CrudRepository;
import com.rabinart.ems.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
public class EmployeeServiceIT {

    private final CrudRepository<Integer, Employee> employeeRepository;

    @Test
    void findById(){

    }

}
