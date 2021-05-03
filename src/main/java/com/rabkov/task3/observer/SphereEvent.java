package com.rabkov.task3.observer;

import com.rabkov.task3.entity.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {

    public SphereEvent(Sphere source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere) super.getSource();
    }
}
