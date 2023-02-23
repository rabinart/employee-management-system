package com.rabinart.ems.integration.controller;

import com.rabinart.ems.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static com.rabinart.ems.database.dto.EmployeeCreateEditDto.Fields.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@RequiredArgsConstructor
public class EmployeeControllerIT extends IntegrationTestBase {

    private final MockMvc mockMvc;


    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpectAll(
                        model().attributeExists("employees"),
                        model().attribute("employees", hasSize(8)),
                        status().is2xxSuccessful()
                );
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/employees")
                        .param(name, "Name")
                        .param(email, "email@em.ail")
                        .param(balance, "0")
                )
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrlPattern("/employees/{\\d+}")
                );
    }
}
