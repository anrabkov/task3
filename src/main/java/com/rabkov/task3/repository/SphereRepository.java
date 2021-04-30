package com.rabkov.task3.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface SphereRepository<T> {
        boolean add(T item);
        boolean remove(T item);
        boolean addAll(Collection<? extends T> items);
        boolean removeAll(Collection<? extends T> items);
        List<T> query(Specification specification);
        List<T> queryStream(Specification specification);
        List<T> sort(Comparator<? super T> comparator);
    }

