package com.rabinart.ems.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.rabinart.ems.database.dto.BusynessFilter;
import com.rabinart.ems.database.entity.Busyness;
import com.rabinart.ems.database.querydsl.QPredicates;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.rabinart.ems.database.entity.QBusyness.*;


@RequiredArgsConstructor
public class FilterBusynessRepositoryImpl implements FilterBusynessRepository{

    private final EntityManager entityManager;


    @Override
    public List<Busyness> findAllBy(BusynessFilter filter) {

        if (filter == null || filter.getTimeFrom() == null || filter.getDateFrom() == null)
            filter = new BusynessFilter(LocalDate.now(),LocalDate.now(), LocalTime.MIN, LocalTime.MAX);

        var dateTimeFrom = LocalDateTime.of(filter.getDateFrom(), filter.getTimeFrom());
        var dateTimeTill = LocalDateTime.of(filter.getDateTill(), filter.getTimeTill());

        var predicate = QPredicates.builder()
                .add(dateTimeFrom, dateTimeTill, busyness.busyFrom::between)
                .add(dateTimeFrom, dateTimeTill, busyness.busyTill::between)
                .buildAnd();

        return new JPAQuery<Busyness>(entityManager)
                .select(busyness)
                .from(busyness)
                .where(predicate)
                .fetch();

    }
}
