package com.rabkov.task3.repository.impl;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.repository.Specification;

public class RadiusSpecification implements Specification {
    private double maxRadius;
    private double minRadius;

    public RadiusSpecification(double maxRadius, double minRadius) {
        this.maxRadius = maxRadius;
        this.minRadius = minRadius;
    }

    @Override
    public boolean specify(Sphere sphere) {
        double radius = sphere.getRadius();
        boolean result = radius >= minRadius && radius <= maxRadius;
        return result;
    }
}
