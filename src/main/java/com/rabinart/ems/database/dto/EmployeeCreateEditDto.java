package com.rabinart.ems.database.dto;

import com.rabinart.ems.database.entity.EmployeeStatus;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@FieldNameConstants
public class EmployeeCreateEditDto {

    String name;
    String email;
    Integer balance;

    PersonalInfoCreateEditDto personalInfo;

    public EmployeeCreateEditDto (String name, String email, Integer balance, Integer age, EmployeeStatus status, String description){
        personalInfo = new PersonalInfoCreateEditDto(age,status,description);
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

}
