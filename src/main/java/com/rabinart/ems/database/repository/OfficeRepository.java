package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

    Optional<OfficeReadDto> findByName(String name);

    Optional<OfficeReadDto> findAllByNameContaining(String name);

}
