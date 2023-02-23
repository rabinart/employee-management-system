package com.rabinart.ems.database.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BusynessReadDto {

    Long id;
    String employeeName;
    String officeName;
    LocalDateTime busyFrom;
    LocalDateTime busyTill;
}
