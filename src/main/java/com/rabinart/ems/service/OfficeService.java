package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.database.entity.Office;
import com.rabinart.ems.database.repository.CrudRepository;
import com.rabinart.ems.database.repository.OfficeRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OfficeService {
    private final CrudRepository<Integer, Office> officeRepository;

    public Optional<OfficeReadDto> findById(Integer id){
        return officeRepository.findById(id)
                .map(e -> new OfficeReadDto(e.getName(), e.getAddress()));
    }
}
