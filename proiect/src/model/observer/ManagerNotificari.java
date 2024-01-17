package model.observer;

import java.util.ArrayList;

public abstract class ManagerNotificari {
    private ArrayList<Observer> observers;

    public ManagerNotificari() {
        super();
        this.observers = new ArrayList<Observer>();
    }

    public ArrayList<Observer> getOrganizatori() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public void inregistrareObserver(Observer observer) {
        observers.add(observer);
    }

    public void dezabonareObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificaObservers(String notificare) {
        for (Observer observer: observers){
            observer.primesteNotificare(notificare);
        }
    }

}
