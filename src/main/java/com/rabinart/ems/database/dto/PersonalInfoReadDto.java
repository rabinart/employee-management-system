package com.rabinart.ems.database.dto;

import com.rabinart.ems.database.entity.EmployeeStatus;
import lombok.Value;

@Value
public class PersonalInfoReadDto {
    Integer id;
    Integer age;
    EmployeeStatus status;
    String description;
}
