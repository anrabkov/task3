package com.rabkov.task3.repository;

import com.rabkov.task3.entity.Sphere;

import java.util.Collection;
import java.util.List;

public interface Repository<Sphere> {
    boolean add(Sphere item);
    boolean remove(Sphere item);
    boolean addAll(Collection<? extends Sphere> items);
    boolean removeAll(Collection<? extends Sphere> items);
    List<Sphere> query(Specification<Sphere> specification);
    List<Sphere> queryStream(Specification<Sphere> specification);
}

