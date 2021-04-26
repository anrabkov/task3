package com.rabkov.task3.service.iml;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.service.CalculationService;

public class CalculationServiceIml implements CalculationService {

    @Override
    public double calculateSurfaceArea(Sphere sphere) {
        double surfaceArea = 4 * Math.PI * sphere.getRadius();
        return surfaceArea;
    }

    @Override
    public double calculateVolume(Sphere sphere) {
        double volume = 4 / 3 * (Math.PI * sphere.getRadius());
        return volume;
    }
}
