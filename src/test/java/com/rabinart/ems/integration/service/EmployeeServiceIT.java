package com.rabinart.ems.integration.service;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.EmployeeReadDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.dto.PersonalInfoReadDto;
import com.rabinart.ems.database.entity.EmployeeStatus;
import com.rabinart.ems.integration.IntegrationTestBase;
import com.rabinart.ems.service.EmployeeService;
import com.rabinart.ems.service.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class EmployeeServiceIT extends IntegrationTestBase {
    private static final String NAME = "Artem";
    private static final String EMAIL = "aretm@rar.ru";
    private static final Integer BALANCE = 0;
    private static final Integer AGE = 18;
    private static final EmployeeStatus STATUS = EmployeeStatus.ACTIVE;
    public static final String DESCRIPTION = "description";

    private final EmployeeService employeeService;
    private final PersonalInfoService infoService;

    @Test
    void findById() {
        var employee = employeeService.findById(1);
        assertTrue(employee.isPresent());
        assertEquals(employee.get().getName(), NAME);
    }

    @Test
    void saveWithoutInfo() {
        var dto = new EmployeeCreateEditDto(NAME, EMAIL, BALANCE, null,null,null);

        var actual = employeeService.create(dto);

        assertThat(actual).isNotNull();

        assertEquals(actual.getName(), NAME);
        assertEquals(actual.getEmail(), EMAIL);
        assertNull(actual.getPersonalInfo());

    }

  /*  @Test
    void saveWithInfo() {
        var info = new PersonalInfoCreateEditDto(AGE, STATUS, DESCRIPTION);
        var dto = new EmployeeCreateEditDto(NAME, EMAIL, BALANCE, info);

        var actual = employeeService.create(dto);

        assertThat(actual).isNotNull();


        assertEquals(actual.getName(), NAME);
        assertEquals(actual.getEmail(), EMAIL);

        assertEquals(DESCRIPTION, actual.getPersonalInfo().getDescription());


    }*/

/*
    @Test
    void update() {
        var dtoBefore = employeeService.findById(1).orElseThrow();
        var info = dtoBefore.getPersonalInfo();
        var editDto = new EmployeeCreateEditDto(
                "newName",
                dtoBefore.getEmail(),
                dtoBefore.getBalance(),
                new PersonalInfoCreateEditDto(info.getAge(),info.getStatus(),info.getDescription()));


        var updated = employeeService.update(1, editDto);

        assertEquals("newName", updated.orElseThrow().getName());
    }
*/

    @Test
    void delete() {

        assertThat(employeeService.findById(1)).isPresent();

        employeeService.delete(1);

        assertThat(employeeService.findById(1)).isEmpty();
    }
}
