package com.rabinart.ems.service;

import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.database.entity.Office;
import com.rabinart.ems.database.repository.CrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OfficeServiceTest {

    public static final int OFFICE_ID = 1;
    public static final String OFFICE_NAME = "Nirvana";
    public static final String OFFICE_ADDRESS = "U njupi na zalupe";
    @Mock
    private CrudRepository<Integer, Office> officeRepository;

    @InjectMocks
    private OfficeService officeService;

    @Test
    void findById() {
        doReturn(
                Optional.of(new Office(OFFICE_ID, OFFICE_NAME, OFFICE_ADDRESS, new ArrayList<>()))
        ).when(officeRepository).findById(OFFICE_ID);

        var actualResult = officeService.findById(OFFICE_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new OfficeReadDto(OFFICE_NAME, OFFICE_ADDRESS);

        actualResult.ifPresent(dto -> assertEquals(expectedResult, dto));
    }
}
