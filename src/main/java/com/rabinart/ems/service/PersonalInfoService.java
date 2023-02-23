package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.entity.PersonalInfo;
import com.rabinart.ems.database.repository.PersonalInfoRepository;
import com.rabinart.ems.mapper.InfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonalInfoService {

    private final PersonalInfoRepository infoRepository;
    private final InfoMapper mapper;

    @Transactional
    public PersonalInfo create(PersonalInfoCreateEditDto dto){
        return infoRepository.save(mapper.toEntity(dto));
    }

    @Transactional
    public PersonalInfo update(Integer id, PersonalInfoCreateEditDto dto){
        var entity = mapper.toEntity(new PersonalInfoCreateEditDto(dto.getAge(), dto.getStatus(), dto.getDescription()));
        entity.setId(id);
        return infoRepository.save(entity);
    }

    @Transactional
    public PersonalInfo update(Integer id, EmployeeCreateEditDto dto){
        var infoDto = dto.getPersonalInfo();
        return update(id, infoDto);
    }
}
