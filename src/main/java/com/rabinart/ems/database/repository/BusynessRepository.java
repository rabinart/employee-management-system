package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.database.entity.Busyness;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BusynessRepository extends JpaRepository<Busyness, Long> {

    @Query("""
        select count(*) from Busyness b 
        where
        ((:from between b.busyFrom and b.busyTill) or 
        (:till between b.busyFrom and b.busyTill) or 
        (:from <= b.busyFrom and :till >= b.busyTill))
        and b.employee.id = :id
    """)
    Long countBusynessByEmployee(LocalDateTime from, LocalDateTime till, Integer id);

    List<Busyness> findAllByOffice_Name(String name);

    @EntityGraph(attributePaths = {"employee","office"})
    List<Busyness> findAll();

}
