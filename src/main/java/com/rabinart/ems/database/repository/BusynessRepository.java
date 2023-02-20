package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.database.entity.Busyness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BusynessRepository extends JpaRepository<Busyness, Long> {

    @Query("""
        select count(*) from Busyness b 
        where
        ((:from between b.busy_from and b.busy_till) or 
        (:till between b.busy_from and b.busy_till) or 
        (:from <= b.busy_from and :till >= b.busy_till))
        and b.employee.id = :id
    """)
    Long countBusynessByEmployee(LocalDateTime from, LocalDateTime till, Integer id);

    List<Busyness> findAllByOffice_Name(String name);

}
