package com.rabkov.task3.warehouse;

import com.rabkov.task3.exception.SphereException;

import java.util.Optional;

public interface Warehouse<T>{

    Optional<T> get(Long id) throws SphereException;
    void put (Long id, T item) throws SphereException;
    void remove(Long id) throws SphereException;
}
