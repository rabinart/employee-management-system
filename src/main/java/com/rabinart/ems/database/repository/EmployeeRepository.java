package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.entity.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Override
    @EntityGraph(attributePaths = {"personalInfo"})
    List<Employee> findAll();
}
