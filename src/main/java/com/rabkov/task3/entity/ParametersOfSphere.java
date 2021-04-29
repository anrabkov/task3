package com.rabkov.task3.entity;

import java.util.Objects;

public class ParametersOfSphere {
    private double surfaceArea;
    private double volume;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ParametersOfSphere{");
        stringBuilder.append("surfaceArea = ").append(surfaceArea);
        stringBuilder.append(", volume = ").append(volume);
        stringBuilder.append("}");
        return stringBuilder.toString();
          }
}
