package design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class WeatherData implements Subject {
    List<Observer> observerList = new ArrayList<>();
    private double temp;
    private double humidity;
    private double pressure;

    @Override
    public void reg(Observer o) {
        if(!observerList.contains(o)){
            observerList.add(o);
        }
    }

    @Override
    public void delObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(temp, humidity, pressure));
    }

    public void setEle(double temp, double humidity, double pressure){
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "(" + temp + " " + humidity + " " + pressure + ")";
    }
}
