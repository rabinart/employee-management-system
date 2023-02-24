package com.rabinart.ems.database.repository;

import com.rabinart.ems.database.dto.BusynessFilter;
import com.rabinart.ems.database.entity.Busyness;

import java.util.List;

public interface FilterBusynessRepository {

    List<Busyness> findAllBy(BusynessFilter filter);
}
