package com.rabinart.ems.integration.database.repository;

import com.rabinart.ems.database.repository.OfficeRepository;
import com.rabinart.ems.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Transactional
@Rollback
class OfficeRepositoryTest {

    private static final Integer NIRVANA_ID = 1;
    private static final String NIRVANA = "NIRVANA";

    private final TransactionTemplate transactionTemplate;
    private final EntityManager entityManager;
    private final OfficeRepository officeRepository;

    @Test
    void create() {
    }

    @Test
    void findById() {
        var office = officeRepository.findById(NIRVANA_ID);
        assertThat(office).isPresent();

        assertEquals(office.get().getName(), NIRVANA);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        var office = officeRepository.findById(NIRVANA_ID);
        assertThat(office).isPresent();

        office.ifPresent(officeRepository::delete);
        entityManager.flush();

        assertThat(officeRepository.findById(NIRVANA_ID)).isEmpty();

    }
}