package com.rabinart.ems.database.dto;

import com.rabinart.ems.database.entity.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;



@Value
public class PersonalInfoCreateEditDto {
    Integer age;
    EmployeeStatus status;
    String description;

}
