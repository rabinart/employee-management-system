package com.rabinart.ems.integration.database.repository;

import com.rabinart.ems.database.repository.BusynessRepository;
import com.rabinart.ems.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RequiredArgsConstructor
class BusynessRepositoryTestIT extends IntegrationTestBase {
    private static final String NIRVANA = "Nirvana";
    private static final Integer BUSYNESS_SIZE_NIRVANA = 4;
    private static final Map<String, LocalDateTime> FREE_SLOT = Map.of(
            "from", LocalDateTime.of(2023,2,19,13,30),
            "till", LocalDateTime.of(2023,2,20,14,0)
            );
    private final BusynessRepository busynessRepository;

    @Test
    void findAllByOffice_Name() {
        var actual = busynessRepository.findAllByOffice_Name(NIRVANA);
        assertThat(actual).isNotEmpty();
        assertThat(actual).hasSize(BUSYNESS_SIZE_NIRVANA);
    }

    @Test
    void checkIfEmployeeIsFree(){
        var count = busynessRepository.countBusynessByEmployee(
                FREE_SLOT.get("from"),
                FREE_SLOT.get("till"),
                3
        );
        assertEquals(0, count);
    }
}