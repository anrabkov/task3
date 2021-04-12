package com.rabkov.task3.repository;

import com.rabkov.task3.entity.Sphere;

public interface Specification<T> {
     boolean specify(T item);
}
