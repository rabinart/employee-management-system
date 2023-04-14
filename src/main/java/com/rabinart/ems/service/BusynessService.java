package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.BusynessCreateDto;
import com.rabinart.ems.database.dto.BusynessDto;
import com.rabinart.ems.database.dto.BusynessFilter;
import com.rabinart.ems.database.dto.BusynessReadDto;
import com.rabinart.ems.database.entity.Busyness;
import com.rabinart.ems.database.repository.BusynessRepository;
import com.rabinart.ems.mapper.BusynessMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BusynessService {
    private final BusynessRepository busynessRepository;
    private final BusynessMapper mapper;

    public List<BusynessReadDto> findAll() {
        return busynessRepository.findAll().stream()
                .map(mapper::toReadDto).toList();
    }

    public List<BusynessReadDto> findAllByFilter(BusynessFilter filter) {
        return busynessRepository.findAllBy(filter).stream()
                .map(mapper::toReadDto)
                .toList();
    }

    public Optional<BusynessDto> findById(Long id) {
        return busynessRepository.findById(id).map(mapper::toDto);
    }


    @Transactional
    public BusynessReadDto create(BusynessCreateDto dto) {
        var entity = busynessRepository.save(mapper.toEntity(dto));
        busynessRepository.flush();
        return mapper.toReadDto(entity);
    }
}
