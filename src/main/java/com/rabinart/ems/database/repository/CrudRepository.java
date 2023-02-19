package com.rabinart.ems.database.repository;

import java.util.Optional;

public interface CrudRepository <I,T>{

    I create(T entity);
    Optional<T> findById(I id);
    T update(T entity, I id);
    void delete(T entity);


}
