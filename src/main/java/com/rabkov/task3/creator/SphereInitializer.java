package com.rabkov.task3.creator;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.repository.impl.SphereRepositoryIml;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.impl.CalculationServiceIml;
import com.rabkov.task3.warehouse.impl.SphereWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereInitializer {


    static Logger logger = LogManager.getLogger();

    public void initializeRepository(Sphere sphere) {
        SphereRepositoryIml repository = SphereRepositoryIml.getInstance();
        repository.add(sphere);

    }

    public void initializeWarehouse(Sphere sphere) throws SphereException {
        SphereWarehouse warehouse = SphereWarehouse.getInstance();
        CalculationService service = new CalculationServiceIml();
        try {
            double surfaceArea = service.calculateSurfaceArea(sphere);
            double volume = service.calculateVolume(sphere);
            warehouse.put(sphere.getSphereId(), surfaceArea, volume);
        } catch (SphereException e) {
            logger.error("Warehouse wasn't filled with Spheres" + sphere, e);
        }
    }
}
