package com.company.truecaller;

public interface Subject {
    void register(Observer observer);
    void notifyObservers();
}
