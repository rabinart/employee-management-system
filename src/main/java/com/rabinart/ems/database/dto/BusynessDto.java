package com.rabinart.ems.database.dto;

import lombok.Value;

import java.time.Instant;
import java.time.LocalDateTime;

@Value
public class BusynessDto {
    Long id;
    String employeeName;
    String officeName;
    LocalDateTime busyFrom;
    LocalDateTime busyTill;
    Integer earned;
    String jobType;
    Instant createdAt;
    String createdBy;
    Instant modifiedAt;
    String modifiedBy;
}
