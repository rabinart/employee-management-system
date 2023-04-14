package com.rabinart.ems.integration.service;

import com.rabinart.ems.database.dto.BusynessCreateDto;
import com.rabinart.ems.database.dto.BusynessDto;
import com.rabinart.ems.database.dto.BusynessFilter;
import com.rabinart.ems.database.dto.BusynessReadDto;
import com.rabinart.ems.integration.IntegrationTestBase;
import com.rabinart.ems.service.BusynessService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class BusynessTestIT extends IntegrationTestBase {
    private final BusynessService busynessService;


    @Test
    void findAll() {
        var actual = busynessService.findAll();
        assertThat(actual).hasSize(4);
        assertThat(actual.get(0).getEmployeeName()).isEqualTo("Artem");
    }

    @Test
    void findById() {
        var actualRes = busynessService.findById(1L);

        assertTrue(actualRes.isPresent());

        var actual = actualRes.get();

        assertEquals(actual.getEarned(), 600);
    }

    @Test
    void findAllByFilter() {
        var filter = new BusynessFilter(
                LocalDateTime.of(2023, 2, 18, 11, 59),
                LocalDateTime.of(2023, 2, 18, 14, 0));
        var actual = busynessService.findAllByFilter(filter);

        assertEquals(1 ,actual.size());
    }

    @Test
    void save() {
        var createDto = new BusynessCreateDto(
                1,
                1,
                LocalDateTime.of(2023, 2, 18, 11, 59),
                LocalDateTime.of(2023, 2, 18, 14, 0),
                100,
                "Job");
        var busynessReadDto = busynessService.create(createDto);
    }
}
