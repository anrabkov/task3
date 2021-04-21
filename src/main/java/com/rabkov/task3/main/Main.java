package com.rabkov.task3.main;

import com.rabkov.task3.entity.ParametersOfSphere;
import com.rabkov.task3.entity.Point;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.observer.SphereEvent;
import com.rabkov.task3.observer.SphereObserver;
import com.rabkov.task3.observer.iml.SphereObserverImpl;
import com.rabkov.task3.parser.DataParser;
import com.rabkov.task3.reader.DataReader;
import com.rabkov.task3.repository.Specification;
import com.rabkov.task3.repository.SphereRepository;
import com.rabkov.task3.repository.iml.RadiusSpecification;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.iml.CalculationServiceIml;
import com.rabkov.task3.sphereFactory.SphereFactory;
import com.rabkov.task3.util.Util;
import com.rabkov.task3.validator.FileNameValidator;
import com.rabkov.task3.warehouse.Warehouse;
import com.rabkov.task3.warehouse.iml.SphereWarehouse;
import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SphereException {
        Util util = new Util();
        String path = util.getFilePath("data/data.txt");
        System.out.println(path);

        FileNameValidator fileNameValidator = new FileNameValidator();
        System.out.println(fileNameValidator.validateFile(path));
        DataReader reader = new DataReader();
        List<String> list = reader.readFromFile(path);
        for (String s : list) {
            System.out.println(s);
        }
//
//        DataParser parser = new DataParser();
//        List<List<Double>> listList = parser.parseString(list);
//        for (List<Double> l : listList) {
//            System.out.println(l);
//        }
//
//        List<Sphere> sphereList = new ArrayList<>();
//        SphereFactory factory = new SphereFactory();
//        for (List<Double> doubleList : listList) {
//            Sphere sphere = factory.buildSphere(doubleList);
//            sphereList.add(sphere);
//        }

//        SphereRepository repository = SphereRepository.getInstance();
//        repository.addAll(sphereList);
//        Specification specification = new RadiusSpecification(5.0, 0.10);
//        List<Sphere> correctRadiusList = repository.query(specification);
//        for (Sphere sphere : correctRadiusList) {
//            System.out.println(sphere.getRadius() + "  " + sphere.getSphereId());
//        }
//
//        SphereWarehouse warehouse = SphereWarehouse.getInstance();
//        long id = correctRadiusList.get(0).getSphereId();
//        warehouse.put(id,
//                new ParametersOfSphere
//                        (new CalculationServiceIml().calculateSurfaceArea(correctRadiusList.get(0)),
//                                new CalculationServiceIml().calculateVolume(correctRadiusList.get(0))));
//
//
//        System.out.println(warehouse.get(id));
//        SphereObserverImpl observer = new SphereObserverImpl();
//        SphereFactory factory1 = new SphereFactory();
//
//        observer.parametersChange(new SphereEvent(new SphereFactory));
//

    }
}