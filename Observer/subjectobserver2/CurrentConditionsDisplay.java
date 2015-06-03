package subjectobserver2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;
    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    
    public void unregister(){
        observable.deleteObserver(this);
    }
    
    public void display() {
        String displayData = "CurrentConditions[temp=" + temp + ", humidity=" + humidity + ", pressure="
                + pressure + "]";
        System.out.println(displayData);
    }

    private float temp;
    private float humidity;
    private float pressure;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

}
