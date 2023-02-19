package com.rabinart.ems.integration.service;


import com.rabinart.ems.EmsApplication;
import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.integration.annotation.IT;
import com.rabinart.ems.service.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
//@ExtendWith({SpringExtension.class})
//@ContextConfiguration(classes = EmsApplication.class, initializers = ConfigDataApplicationContextInitializer.class)
//@ActiveProfiles("test")
//@SpringBootTest
@IT
@RequiredArgsConstructor
public class OfficeServiceIT {

    private static final String OFFICE_NAME ="Nirvana";
    private static final Integer OFFICE_ID = 1;
    private static final String OFFICE_ADDRESS = "Boryivojova";

    private final OfficeService officeService;

    @Test
    void findById(){

        var expected = new OfficeReadDto(OFFICE_NAME, OFFICE_ADDRESS);

        var actual = officeService.findById(OFFICE_ID);

        assertTrue(actual.isPresent());

        assertEquals(actual.get(), expected);
    }
}
