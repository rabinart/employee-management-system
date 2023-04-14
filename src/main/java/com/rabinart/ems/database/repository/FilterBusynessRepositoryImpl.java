package com.rabinart.ems.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.rabinart.ems.database.dto.BusynessFilter;
import com.rabinart.ems.database.entity.Busyness;
import com.rabinart.ems.database.querydsl.QPredicates;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.rabinart.ems.database.entity.QBusyness.*;


@RequiredArgsConstructor
public class FilterBusynessRepositoryImpl implements FilterBusynessRepository{

    private final EntityManager entityManager;


    @Override
    public List<Busyness> findAllBy(BusynessFilter filter) {
        var predicate = QPredicates.builder()
                .add(filter.getFrom(), filter.getTill(), busyness.busyFrom::between)
                .add(filter.getFrom(), filter.getTill(), busyness.busyTill::between)
                .buildAnd();

        return new JPAQuery<Busyness>(entityManager)
                .select(busyness)
                .from(busyness)
                .where(predicate)
                .fetch();

    }
}
