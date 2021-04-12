package com.rabkov.task3.sphereFactory;

import com.rabkov.task3.entity.Point;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;

import java.util.List;


public class SphereFactory  {

    public static Sphere buildSphere(List<Double> list) throws SphereException {
        if (list.get(3)  == 0){
            throw new SphereException("Radius can not be equal to 0");
        }
            Point point = new Point(list.get(0), list.get(1), list.get(2));
            Sphere sphere = new Sphere(point, list.get(3));
        return sphere;
    }

    public static Sphere buildSphere(Point point, long radius) throws SphereException{
        if (radius == 0){
            throw new SphereException("Radius can not be equal to 0");
        }
        Sphere sphere = new Sphere(point, radius);
        return sphere;
    }
}
