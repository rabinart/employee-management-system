package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.database.entity.Busyness;
import org.hibernate.envers.RevisionEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BusynessRepository extends
        JpaRepository<Busyness, Long>,
        FilterBusynessRepository,
        QuerydslPredicateExecutor<Busyness>,
        RevisionRepository<Busyness, Long, Integer> {

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
