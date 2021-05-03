package com.rabkov.task3.generatorId;

public class GeneratorId {

    private static long counter;

    private GeneratorId() {
    }

    public static long generateId() {
        return ++counter;
    }
}
