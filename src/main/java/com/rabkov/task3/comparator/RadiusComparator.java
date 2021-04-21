package com.rabkov.task3.comparator;

import com.rabkov.task3.entity.Sphere;

import java.util.Comparator;

public class RadiusComparator implements Comparator<Sphere> {

    public int compare(Sphere s1, Sphere s2){
        int result = Double.compare(s1.getRadius(), s2.getRadius());
        return result;
    }
}
