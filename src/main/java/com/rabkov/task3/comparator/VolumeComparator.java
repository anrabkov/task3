package com.rabkov.task3.comparator;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.iml.CalculationServiceIml;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Sphere> {

    public int compare(Sphere s1, Sphere s2){
        CalculationService service = new CalculationServiceIml();
        int result = Double.compare(service.calculateVolume(s1), service.calculateVolume(s2));
        return result;
    }
}
