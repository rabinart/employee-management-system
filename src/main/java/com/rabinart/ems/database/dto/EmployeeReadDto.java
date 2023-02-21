package com.rabinart.ems.database.dto;

import lombok.Value;

@Value
public class EmployeeReadDto {
    Integer id;
    String name;
    String email;
    Integer balance;
}
