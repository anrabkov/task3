package com.rabkov.task3.observer.iml;

import com.rabkov.task3.entity.ParametersOfSphere;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.observer.SphereEvent;
import com.rabkov.task3.observer.SphereObserver;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.iml.CalculationServiceIml;
import com.rabkov.task3.warehouse.iml.SphereWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserverImpl implements SphereObserver {

    static Logger logger = LogManager.getLogger();

    @Override
    public void parametersChange(SphereEvent event) {
        Sphere sphere = event.getSource();
        CalculationService service = new CalculationServiceIml();
        SphereWarehouse warehouse = SphereWarehouse.getInstance();
        Long sphereId = sphere.getSphereId();
        try {
            double surfaceArea = service.calculateSurfaceArea(sphere);
            double volume = service.calculateVolume(sphere);
            ParametersOfSphere parameters = new ParametersOfSphere(surfaceArea, volume);
            warehouse.put(sphereId, parameters);
        } catch (SphereException e) {
            logger.error("warehouse didn't update", e.getCause());
        }
    }
}
