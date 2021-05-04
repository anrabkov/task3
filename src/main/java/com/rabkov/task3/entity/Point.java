package com.rabkov.task3.entity;

public class Point implements Cloneable {

    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(x);
        result = prime * result + Double.hashCode(y);
        result = prime * result + Double.hashCode(z);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return Double.compare(this.x, point.x) == 0 && Double.compare(this.y, point.y) == 0
                && Double.compare(this.z, point.z) == 0;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Point{");
        stringBuilder.append("x = ").append(x);
        stringBuilder.append(", y = ").append(y);
        stringBuilder.append(", z = ").append(z);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public Point clone() {
        Point point = null;
        try {
            point = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return point;
    }
}
