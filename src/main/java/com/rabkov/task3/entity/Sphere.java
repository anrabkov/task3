package com.rabkov.task3.entity;

import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.generatorId.GeneratorId;
import com.rabkov.task3.observer.Observable;
import com.rabkov.task3.observer.SphereEvent;
import com.rabkov.task3.observer.SphereObserver;

import java.util.Objects;

public class Sphere implements Observable {

 private long sphereId;
 private Point point;
 private double radius;
 private SphereObserver observer = null;

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

    public void setPoint(Point point) throws SphereException {
        if (point == null){
            throw new SphereException("Point cannot be equal to null");
        }
        this.point = point;
        notifyObserver();
    }

    public void setRadius(double radius) throws SphereException {
        if (radius == 0){
            throw new SphereException("Radius cannot be equal to 0");
        }
        this.radius = radius;
        notifyObserver();
    }

    @Override
    public void attachObserver(SphereObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detachObserver() {
        observer = null;

    }

    @Override
    public void notifyObserver() {
        if (observer != null){
            observer.parametersChange(new SphereEvent(this));
        }

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
