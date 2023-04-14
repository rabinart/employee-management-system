package com.rabinart.ems.integration.database.repository;

import com.rabinart.ems.database.dto.BusynessFilter;
import com.rabinart.ems.database.entity.Busyness;
import com.rabinart.ems.database.repository.BusynessRepository;
import com.rabinart.ems.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Test
    void modifiedAtAuditing() {
        var entity = busynessRepository.findById(1L);
        var busyness = entity.orElseThrow();
        busyness.setJobType("new job type");
        busynessRepository.flush();
        System.out.println();
    }

    @Test
    void findByFilter(){
        var busynesses = busynessRepository.findAllBy(new BusynessFilter(
                LocalDateTime.of(2000, 1, 1, 0, 0),
                LocalDateTime.of(2025, 1, 1, 0, 0)
        ));

        assertThat(busynesses).hasSize(4);
    }

    @Test
    void findNextDay() {
        var allNextDay = busynessRepository.findAllBy(new BusynessFilter(
                LocalDateTime.of(2023, 2, 19, 0, 0),
                LocalDateTime.of(2023, 2, 20, 0, 0)
        ));

        assertThat(allNextDay).hasSize(1);
    }
}