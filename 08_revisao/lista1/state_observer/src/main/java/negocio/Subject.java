package negocio;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Observer> vetObserver;

    public Subject(){
        this.vetObserver = new ArrayList<Observer>();
    }

    public void addObserver(Observer observer)  {
        this.vetObserver.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.vetObserver.remove(observer);
    }

    public void removeObserver(int i){
        this.vetObserver.remove(i);
    }

    protected abstract void notifyObservers();

}
