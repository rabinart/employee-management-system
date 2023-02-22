package com.rabinart.ems.integration.service;

import com.rabinart.ems.database.dto.EmployeeCreateEditDto;
import com.rabinart.ems.database.dto.EmployeeReadDto;
import com.rabinart.ems.database.dto.PersonalInfoCreateEditDto;
import com.rabinart.ems.database.entity.EmployeeStatus;
import com.rabinart.ems.integration.IntegrationTestBase;
import com.rabinart.ems.service.EmployeeService;
import com.rabinart.ems.service.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        var dto = new EmployeeCreateEditDto(NAME, EMAIL, BALANCE);

        var actual = employeeService.create(dto, null);

        assertThat(actual).isNotNull();

        assertEquals(actual.getName(), NAME);
        assertEquals(actual.getEmail(), EMAIL);

    }

    @Test
    void saveWithInfo() {
        var dto = new EmployeeCreateEditDto(NAME, EMAIL, BALANCE);
        var info = new PersonalInfoCreateEditDto(AGE, STATUS, DESCRIPTION);

        var actual = employeeService.create(dto, info);

        assertThat(actual).isNotNull();


        assertEquals(actual.getName(), NAME);
        assertEquals(actual.getEmail(), EMAIL);

        assertEquals(DESCRIPTION, actual.getPersonalInfo().getDescription());


    }

    @Test
    void update() {
        var dtoBefore = employeeService.findById(1).get();
        var editDto = new EmployeeCreateEditDto("newName", dtoBefore.getEmail(), dtoBefore.getBalance());
        var update = employeeService.update(1, editDto);

        assertEquals("newName", update.get().getName());
    }

    @Test
    void delete() {

        assertThat(employeeService.findById(1)).isPresent();

        employeeService.delete(1);

        assertThat(employeeService.findById(1)).isEmpty();
    }
}
