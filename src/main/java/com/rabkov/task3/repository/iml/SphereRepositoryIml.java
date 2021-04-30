package com.rabkov.task3.repository.iml;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.repository.Specification;
import com.rabkov.task3.repository.SphereRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SphereRepositoryIml implements SphereRepository<Sphere> {
    private static final SphereRepositoryIml instance = new SphereRepositoryIml();
    private List<Sphere> sphereList;

    private SphereRepositoryIml() {
        sphereList = new ArrayList<>();
    }

    public static SphereRepositoryIml getInstance() {
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

    public List<Sphere> sort(Comparator<? super Sphere> comparator){
        return sphereList.stream().sorted(comparator).collect(Collectors.toList());
    }
}




