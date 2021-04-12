package com.rabkov.task3.repository.iml;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.repository.Repository;
import com.rabkov.task3.repository.Specification;


import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class SphereRepository implements Repository {
    private static SphereRepository instance = null;
    private List<Sphere> collection;

    private SphereRepository() {
        collection = new ArrayList<>();
    }

    public static SphereRepository getInstance() {
        if (instance == null) {
            instance = new SphereRepository();
        }
        return instance;
    }

    @Override
    public boolean add(Sphere item) {
        return collection.add(item);
    }

    @Override
    public boolean remove(Sphere item) {
        return collection.remove(item);
    }

    @Override
    public boolean addAll(Collection items) {
        return collection.addAll(items);
    }

    @Override
    public boolean removeAll(Collection items) {
        return collection.removeAll(items);
    }

    @Override
    public List<Sphere> query(Specification<Sphere> specification) {
        List<Sphere> correctList = new ArrayList<>();
        for (Sphere item : collection){
            if (specification.specify(item)){
                correctList.add(item);
            }
        }
        return correctList;
    }

    @Override
    public List<Sphere> queryStream(Specification<Sphere> specification) {
        List<Sphere> correctList = collection.stream()
                .filter(specification ::specify)
                .collect(Collectors.toList());
        return correctList;
    }
}


