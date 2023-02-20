package com.rabinart.ems.integration.database.repository;

import com.rabinart.ems.database.repository.OfficeRepository;
import com.rabinart.ems.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@RequiredArgsConstructor
class OfficeRepositoryTestIT extends IntegrationTestBase {

    private static final Integer NIRVANA_ID = 1;
    private static final String NIRVANA = "Nirvana";

    private final OfficeRepository officeRepository;

    @Test
    void create() {
    }

    @Test
    void findById() {
        var office = officeRepository.findById(NIRVANA_ID);
        assertThat(office).isPresent();

        assertEquals(NIRVANA, office.get().getName());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        var office = officeRepository.findById(NIRVANA_ID);
        assertThat(office).isPresent();

        office.ifPresent(officeRepository::delete);
        officeRepository.flush();

        assertThat(officeRepository.findById(NIRVANA_ID)).isEmpty();

    }
}