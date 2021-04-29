package com.rabkov.task3.repository;

import com.rabkov.task3.entity.Sphere;



import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class SphereRepository  {
    private static SphereRepository instance = null;
    private List<Sphere> sphereList;

    private SphereRepository() {
        sphereList = new ArrayList<>();
    }

    public static SphereRepository getInstance() {
        if (instance == null) {
            instance = new SphereRepository();
        }
        return instance;
    }

    public boolean add(Sphere sphere) {
        return sphereList.add(sphere);
    }

    public boolean remove(Sphere sphere) {
        return sphereList.remove(sphere);
    }

    public boolean addAll(Collection spheres) {
        return sphereList.addAll(spheres);
    }

    public boolean removeAll(Collection spheres) {
        return sphereList.removeAll(spheres);
    }


    public List<Sphere> query(Specification specification) {
        List<Sphere> correctList = new ArrayList<>();
        for (Sphere sphere : sphereList){
            if (specification.specify(sphere)){
                correctList.add(sphere);
            }
        }
        return correctList;
    }

    public List<Sphere> queryStream(Specification specification) {
        List<Sphere> correctList = sphereList.stream()
                .filter(specification ::specify)
                .collect(Collectors.toList());
        return correctList;
    }
}


