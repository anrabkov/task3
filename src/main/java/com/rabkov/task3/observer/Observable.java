package com.rabkov.task3.observer;

public interface Observable {
    void attachObserver(SphereObserver observer);
    void detachObserver();
    void notifyObserver();
}
