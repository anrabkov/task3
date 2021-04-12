package com.rabkov.task3.entity;

import java.util.Objects;

public class ParametersOfSphere {
    private double surfaceArea;
    private double volume;

    public ParametersOfSphere(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametersOfSphere that = (ParametersOfSphere) o;
        return surfaceArea == that.surfaceArea && volume == that.volume;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Double.hashCode(surfaceArea);
        result = result * prime + Double.hashCode(volume);

        return result;
    }

    @Override
    public String toString() {
        return "ParametersOfSphere{" +
                "surfaceArea=" + surfaceArea +
                ", volume=" + volume +
                '}';
    }
}
