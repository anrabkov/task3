package com.rabkov.task3.repository.iml;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.repository.Specification;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.iml.CalculationServiceIml;

public class VolumeSpecification implements Specification {

    private double maxVolume;
    private double minVolume;

    public VolumeSpecification(double maxVolume, double minVolume) {
        this.maxVolume = maxVolume;
        this.minVolume = minVolume;
    }

    @Override
    public boolean specify(Sphere sphere) {
        CalculationService service = new CalculationServiceIml();
        double volume = service.calculateVolume(sphere);
        boolean result = volume >=minVolume && volume <=maxVolume;
        return result;
    }
}

