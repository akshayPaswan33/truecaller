package com.company.truecaller;

import java.util.ArrayList;
import java.util.List;

public class Call implements Subject{

    private User dialler;

    List<Observer> observerList;

    public Call() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observerList) observer.update();
    }

    public void makeCall(User dialler) {
        this.dialler = dialler;
        notifyObservers();
    }

    public User getDialler() {
        return dialler;
    }
}
