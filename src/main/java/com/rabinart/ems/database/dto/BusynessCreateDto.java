package com.rabinart.ems.database.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BusynessCreateDto {
    Integer employeeId;
    Integer officeId;
    LocalDateTime busyFrom;
    LocalDateTime busyTill;
    Integer earned;
    String jobType;
}
