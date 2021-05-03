package com.rabkov.task3.repository.impl;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.repository.Specification;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.impl.CalculationServiceIml;

public class SurfaceAreaSpecification implements Specification {
    private double maxArea;
    private double minArea;

    public SurfaceAreaSpecification(double maxArea, double minArea) {
        this.maxArea = maxArea;
        this.minArea = minArea;
    }

    @Override
    public boolean specify(Sphere sphere) {
        CalculationService service = new CalculationServiceIml();
        double area = service.calculateSurfaceArea(sphere);
        boolean result = area >= minArea && area <= maxArea;
        return result;
    }
}

