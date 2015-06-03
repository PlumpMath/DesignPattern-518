package subjectobserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{

    private float temp;
    private float humidity;
    private float pressure;
    private List<Observer> observerList;
    
    public WeatherData(){
        observerList = new ArrayList<Observer>();
    }
    
    public void setWeatherData(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        dataChanged();
    }
    
    public void dataChanged(){
        notifyObserver();
    }
    
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        int index = observerList.indexOf(observer);
        if (index >= 0) {
            observerList.remove(observer);
        }
    }

    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(temp, humidity, pressure);
        }
    }
    
    public float getTemp() {
        return temp;
    }
    
    public void setTemp(float temp) {
        this.temp = temp;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
    
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
