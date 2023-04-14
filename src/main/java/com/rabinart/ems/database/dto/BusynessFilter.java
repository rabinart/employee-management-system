package com.rabinart.ems.database.dto;

import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Value
public class BusynessFilter {

    LocalDate dateFrom;

    LocalDate dateTill;
    LocalTime timeFrom;
    LocalTime timeTill;
}
