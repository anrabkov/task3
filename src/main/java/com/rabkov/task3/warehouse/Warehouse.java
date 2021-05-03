package com.rabkov.task3.warehouse;

import com.rabkov.task3.entity.ParametersOfSphere;
import com.rabkov.task3.exception.SphereException;

import java.util.Optional;

public interface Warehouse<T> {

    Optional<ParametersOfSphere> get(Long id) throws SphereException;

    void put(Long id, double surfaceArea, double volume) throws SphereException;

    void remove(Long id) throws SphereException;
}
