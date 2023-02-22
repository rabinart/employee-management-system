package com.rabinart.ems.database.dto;

import lombok.Value;

@Value
public class EmployeeCreateEditDto {

    String name;
    String email;
    Integer balance;

}
