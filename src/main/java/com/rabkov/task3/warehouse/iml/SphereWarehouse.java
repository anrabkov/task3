package com.rabkov.task3.warehouse.iml;

import com.rabkov.task3.entity.ParametersOfSphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SphereWarehouse implements Warehouse<ParametersOfSphere> {
    private static SphereWarehouse instance = null;
    private Map<Long, ParametersOfSphere> map;

    private SphereWarehouse() {
        map = new HashMap<>();
    }

    public static SphereWarehouse getInstance() {
        if (instance == null) {
            instance = new SphereWarehouse();
        }
        return instance;
    }

    @Override
    public Optional<ParametersOfSphere> get(Long id) throws SphereException {
        if (id == null) {
            throw new SphereException("Id cannot be equal to null");
        }
        ParametersOfSphere parameters = map.get(id);
        return parameters == null ? Optional.empty() : Optional.of(parameters);
    }

    @Override
    public void put(Long id, ParametersOfSphere item) throws SphereException {
        if (id == null) {
            throw new SphereException("Id cannot be equal to null");
        }

        if (item == null) {
            throw new SphereException("Parameters of sphere cannot be equal to null");
        }
        map.put(id, item);
    }

    @Override
    public void remove(Long id) throws SphereException {
        if (id == null){
            throw new SphereException("Id cannot be equal to null");
        }
        map.remove(id);
    }
}
