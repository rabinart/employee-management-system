package com.rabinart.ems.integration.database.repository;

import com.rabinart.ems.database.entity.Office;
import com.rabinart.ems.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Transactional
class OfficeRepositoryTest {

    private final EntityManager entityManager;

    @Test
    void create() {
    }

    @Test
    void findById() {
        var office = entityManager.find(Office.class, 1);
        assertEquals(office.getName(), "Nirvana");

        assertThat(office.getBusyness()).hasSize(4);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}