package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.database.entity.Office;
import com.rabinart.ems.database.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    @Transactional(readOnly = true)
    public Optional<OfficeReadDto> findById(Integer id){
        return officeRepository.findById(id)
                .map(office -> new OfficeReadDto(office.getName(), office.getAddress()));
    }
}
