package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.entity.Employee;
import jakarta.persistence.Embeddable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
