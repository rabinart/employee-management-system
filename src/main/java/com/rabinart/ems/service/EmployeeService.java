package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.EmployeeReadDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.entity.Employee;
import com.rabinart.ems.database.entity.PersonalInfo;
import com.rabinart.ems.database.repository.EmployeeRepository;
import com.rabinart.ems.mapper.EmployeeMapper;
import com.rabinart.ems.mapper.InfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PersonalInfoService infoService;
    private final EmployeeMapper employeeMapper;
    private final InfoMapper infoMapper;

    public List<EmployeeReadDto> findAll() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }

    public Optional<EmployeeReadDto> findById(Integer id) {
        var employee = employeeRepository.findById(id);
        return employee.map(employeeMapper::toDto);
    }

    @Transactional
    public EmployeeReadDto create(EmployeeCreateEditDto dto) {
        PersonalInfo info = null;
        if (dto.getPersonalInfo() != null){
            info = infoService.create(dto.getPersonalInfo());
        }

        var entity = employeeMapper.toEntity(dto);
        entity.setPersonalInfo(info);
        var employee = employeeRepository.saveAndFlush(entity);
        return employeeMapper.toDto(employee);
    }

    @Transactional()
    public Optional<EmployeeReadDto> update(Integer id, EmployeeCreateEditDto dto) {
        var employee = employeeRepository.findById(id);
        return employee.map(e -> {
            var info = e.getPersonalInfo();
            infoMapper.update(info, dto.getPersonalInfo());
            infoService.update(info.getId(), dto.getPersonalInfo());
            e.setPersonalInfo(info);
            employeeMapper.update(e, dto);
            employeeRepository.saveAndFlush(e);
            return employeeMapper.toDto(e);
        });
    }

    @Transactional
    public Boolean delete(Integer id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employeeRepository.delete(employee);
                    employeeRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
