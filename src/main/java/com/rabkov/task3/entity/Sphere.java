package com.rabkov.task3.entity;

import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.generatorId.GeneratorId;

import java.util.Objects;

public class Sphere {

 private long sphereId;
 private Point point;
 private double radius;

    public Sphere(Point point, double radius) throws SphereException {
        if (point == null || radius == 0){
            throw new SphereException("Sphere can not build");
        }
        this.point = point;
        this.radius = radius;
        this.sphereId = GeneratorId.generateId();
    }

    public long getSphereId() {
        return sphereId;
    }

    public Point getPoint() {
        return point;
    }

    public double getRadius() {
        return radius;
    }

    public void setSphereId(long sphereId) {
        this.sphereId = sphereId;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return sphereId == sphere.sphereId && Double.compare(sphere.radius, radius) == 0
                && Objects.equals(point, sphere.point);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + point.hashCode();
        result = result * prime + Double.hashCode(radius);

        return result;
    }


}
