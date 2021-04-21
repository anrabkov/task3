package com.rabkov.task3.repository.iml;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.repository.Specification;

public class IdSpecification implements Specification {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Sphere sphere) {
        boolean result = sphere.getSphereId() == id;
        return result;
    }
}
