package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.BusynessReadDto;
import com.rabinart.ems.database.repository.BusynessRepository;
import com.rabinart.ems.mapper.BusynessMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusynessService {
    private final BusynessRepository busynessRepository;
    private final BusynessMapper mapper;

    public List<BusynessReadDto> findAll() {
        return busynessRepository.findAll().stream()
                .map(mapper::toDto).toList();
    }
}
