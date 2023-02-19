package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.entity.Employee;
import jakarta.persistence.Embeddable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository implements CrudRepository<Integer, Employee> {
    @Override
    public Integer create(Employee entity) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Employee update(Employee entity, Integer id) {
        return null;
    }

    @Override
    public void delete(Employee entity) {

    }
}
