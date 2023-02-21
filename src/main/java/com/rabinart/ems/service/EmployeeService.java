package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.EmployeeReadDto;
import com.rabinart.ems.database.repository.EmployeeRepository;
import com.rabinart.ems.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeReadDto> findAll(){
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    public Optional<EmployeeReadDto> findById(Integer id){
        var employee = employeeRepository.findById(id);
        return employee.map(employeeMapper::toDto);
    }

    public Integer create(EmployeeCreateEditDto dto){
        var employee = employeeRepository.save(employeeMapper.toEntity(dto));

        return employee.getId();
    }

    public Integer update(Integer id, EmployeeCreateEditDto dto){
        var emp = employeeRepository.findById(id);
        return null;
    }
}
