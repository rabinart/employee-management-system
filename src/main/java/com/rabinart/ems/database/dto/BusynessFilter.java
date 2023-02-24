package com.rabinart.ems.database.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BusynessFilter {

    LocalDateTime from;
    LocalDateTime till;
}
