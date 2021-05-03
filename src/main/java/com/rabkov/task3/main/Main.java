package com.rabkov.task3.main;

import com.rabkov.task3.creator.SphereInitializer;

import com.rabkov.task3.entity.ParametersOfSphere;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.observer.impl.SphereObserverImpl;
import com.rabkov.task3.parser.DataParser;
import com.rabkov.task3.reader.DataReader;
import com.rabkov.task3.repository.impl.SphereRepositoryIml;
import com.rabkov.task3.repository.impl.IdSpecification;
import com.rabkov.task3.repository.impl.RadiusSpecification;
import com.rabkov.task3.sphereFactory.SphereFactory;
import com.rabkov.task3.warehouse.impl.SphereWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws SphereException {
        SphereInitializer sphereInitializer = new SphereInitializer();
        SphereRepositoryIml repository = SphereRepositoryIml.getInstance();
        SphereWarehouse warehouse = SphereWarehouse.getInstance();

        DataReader reader = new DataReader();
        List<String> list = reader.readFromFile("data/data.txt");
        for (String s : list) {
            logger.info(s);
        }

        DataParser parser = new DataParser();
        List<List<Double>> listList = parser.parseString(list);
        for (List<Double> l : listList) {
            logger.info(l);
        }

        SphereFactory factory = new SphereFactory();
        for (List<Double> doubleList : listList) {
            Sphere sphere = factory.buildSphere(doubleList);
            sphere.attachObserver(new SphereObserverImpl());
            sphereInitializer.initializeRepository(sphere);
            sphereInitializer.initializeWarehouse(sphere);
        }

        List<Sphere> sphereListToId = repository.query(new IdSpecification(2));
        Sphere sphereToId = sphereListToId.get(0);
        ParametersOfSphere parameters = warehouse.get(sphereToId.getSphereId()).orElse(new ParametersOfSphere());
        logger.info("SurfaceArea was equal to " + parameters.getSurfaceArea() + ",    " +
                "Volume was equal to  " + parameters.getVolume());
        sphereToId.setRadius(25);
        logger.info("SurfaceArea became equal to " + parameters.getSurfaceArea() + ",    " +
                "Volume became equal to  " + parameters.getVolume());


        List<Sphere> listToRadius = repository.query(new RadiusSpecification(15, 0.1));
        for (Sphere sphere : listToRadius) {
            logger.info(sphere.toString());
        }
    }
}





