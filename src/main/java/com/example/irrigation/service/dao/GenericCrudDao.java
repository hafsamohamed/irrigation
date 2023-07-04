package com.example.irrigation.service.dao;

import java.util.List;
import java.util.Optional;

public interface GenericCrudDao<T, Id> {
    T save(T entity);

    T update(T entity);

    Optional<T> findById(Id id);

    List<T> findAll();

}