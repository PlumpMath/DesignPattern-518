package subjectobserver2;

import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements Observer, DisplayElement{

    private Observable observable;
    public HeatIndexDisplay(Observable observable){
        observable.addObserver(this);
        this.observable = observable;
    }
    
    public void unregister(){
        observable.deleteObserver(this);
    }
    
    @Override
    public void display() {
        System.out.println("当前酷热指数:" + getHeatIndex());
    }
    
    private float getHeatIndex(){
        float heatIndex = 0F;
        heatIndex = (float) (temp*Math.PI + humidity*Math.E + pressure*1.01315)/5;
        return heatIndex;
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
