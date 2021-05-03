package com.rabkov.task3.service.impl;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.service.CalculationService;

public class CalculationServiceIml implements CalculationService {

    @Override
    public double calculateSurfaceArea(Sphere sphere) {
        double surfaceArea = 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
        return surfaceArea;
    }

    @Override
    public double calculateVolume(Sphere sphere) {
        double volume = 4 / 3 * Math.PI * Math.pow(sphere.getRadius(), 3);
        return volume;
    }
}
