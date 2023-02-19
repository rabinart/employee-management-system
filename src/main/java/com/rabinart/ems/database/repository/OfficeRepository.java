package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.entity.Office;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OfficeRepository implements CrudRepository<Integer, Office>{

    private final EntityManager entityManager;
    @Override
    public Integer create(Office entity) {
        return null;
    }

    @Override
    public Optional<Office> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Office.class, id));
    }

    @Override
    public Office update(Office entity, Integer id) {
        return null;
    }

    @Override
    public void delete(Office entity) {

    }
}
