package com.rabinart.ems.integration.service;


import com.rabinart.ems.database.dto.OfficeReadDto;
import com.rabinart.ems.integration.annotation.IT;
import com.rabinart.ems.service.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
